#!/usr/bin/env python3
"""Check code parity, then compile and test normal and comment-only debug solutions."""
import json
from pathlib import Path
import re
import subprocess
import tempfile

ROOT = Path(__file__).resolve().parents[1]
cases = json.loads((ROOT / "tests" / "cases.json").read_text())
normal = sorted((ROOT / "solutions").rglob("Solution.java"))
debug = sorted((ROOT / "solutions").rglob("SolutionDebug.java"))
if len(cases) != len(normal) or len(debug) != len(normal):
    raise SystemExit("Every solution must have a debug copy and a test case")

# Preserve strings/characters while removing comments. Compare tokens so comments
# and formatting cannot hide a changed algorithm. The unused wildcard import is optional.
LEX = re.compile(r'"(?:\\.|[^"\\])*"|\'(?:\\.|[^\'\\])*\'|//[^\n]*|/\*[\s\S]*?\*/')
TOKENS = re.compile(r'"(?:\\.|[^"\\])*"|\'(?:\\.|[^\'\\])*\'|\w+|[^\s]')


def code_tokens(source):
    source = LEX.sub(lambda match: "" if match[0].startswith(("//", "/*")) else match[0], source)
    source = re.sub(r"import\s+java\.util\.\*;", "", source)
    source = source.replace("class SolutionDebug", "class Solution")
    return TOKENS.findall(source)


for source in normal:
    annotated = source.with_name("SolutionDebug.java")
    if code_tokens(source.read_text()) != code_tokens(annotated.read_text()):
        raise SystemExit(f"Debug algorithm differs from original: {annotated}")
    text = annotated.read_text()
    starts = re.findall(r"LOOP START (L\d+):", text)
    ends = re.findall(r"LOOP END (L\d+) ", text)
    if sorted(starts) != sorted(ends) or len(starts) != len(set(starts)):
        raise SystemExit(f"Loop labels do not pair uniquely: {annotated}")

with tempfile.TemporaryDirectory(prefix="dsa-tests-") as temporary:
    build = Path(temporary)
    harnesses = []
    runs = []
    for index, case in enumerate(cases):
        for variant in ("Solution", "SolutionDebug"):
            class_name = "Check" if variant == "Solution" else "CheckDebug"
            path = build / f"case_{index}" / f"{class_name}.java"
            path.parent.mkdir(exist_ok=True)
            body = re.sub(r"\bSolution\b", variant, case["test"])
            path.write_text(
                "package " + case["package"] + ";\nimport java.util.*;\n"
                + "public class " + class_name + " {\n"
                + "static void check(boolean value) { if (!value) throw new AssertionError(); }\n"
                + "public static void main(String[] args) { " + variant + " s = new " + variant + "();\n"
                + body + "\n}\n}\n"
            )
            harnesses.append(path)
            runs.append((case, class_name))
    classes = build / "classes"
    classes.mkdir()
    subprocess.run(["javac", "-Xlint:all", "-d", str(classes), *map(str, normal + debug + harnesses)], check=True)
    for case, class_name in runs:
        result = subprocess.run(
            ["java", "-cp", str(classes), case["package"] + "." + class_name],
            capture_output=True, text=True,
        )
        if result.returncode:
            raise SystemExit(f"FAIL {case['title']} ({class_name})\n{result.stderr}")
        if result.stdout or result.stderr:
            raise SystemExit(f"Unexpected console output: {case['title']} ({class_name})")
        if class_name == "CheckDebug":
            print("PASS original + debug: " + case["title"], flush=True)
print(f"Passed {len(cases)} problems in both versions ({len(runs)} runs).")
