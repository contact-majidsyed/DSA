#!/usr/bin/env python3
"""Compile every Java solution and run isolated assertions using only the standard library."""
import json
from pathlib import Path
import subprocess
import tempfile

ROOT = Path(__file__).resolve().parents[1]
cases = json.loads((ROOT / "tests" / "cases.json").read_text())
sources = sorted((ROOT / "solutions").rglob("Solution.java"))
if len(cases) != len(sources):
    raise SystemExit("Every solution must have a test case")
with tempfile.TemporaryDirectory(prefix="dsa-tests-") as temporary:
    build = Path(temporary)
    harnesses = []
    for index, case in enumerate(cases):
        path = build / f"case_{index}" / "Check.java"
        path.parent.mkdir()
        path.write_text(
            "package " + case["package"] + ";\nimport java.util.*;\n"
            "public class Check {\n"
            "static void check(boolean value) { if (!value) throw new AssertionError(); }\n"
            "public static void main(String[] args) { Solution s = new Solution();\n"
            + case["test"] + "\n}\n}\n"
        )
        harnesses.append(path)
    classes = build / "classes"
    classes.mkdir()
    subprocess.run(["javac", "-Xlint:all", "-d", str(classes), *map(str, sources + harnesses)], check=True)
    for case in cases:
        subprocess.run(["java", "-cp", str(classes), case["package"] + ".Check"], check=True)
        print("PASS " + case["title"], flush=True)
print(f"Passed {len(cases)} solution checks.")
