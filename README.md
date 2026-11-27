# DSA Interview Practice

An undated Java study collection: 45 coding questions in nine sections, five system design prompts, and ten behavioral prompts. Difficulty labels reflect the supplied study plan's preparation tiers, not official platform ratings.

- [Study plan](STUDY_PLAN.md): topic sequence, priorities, practice routine, and mock interviews.
- [Question bank](QUESTION_BANK.md): every question, difficulty, solution, and explanation.
- [Open the Two Sum visualizer](https://contact-majidsyed.github.io/DSA/): step through the code, array, and map. [Build instructions](visualizer/README.md).
- [Java array printing](notes/java-array-printing.md): `Arrays.toString`, loops, and nested arrays.
- [System design](system-design/README.md): reference approaches and separate ASCII explanations.
- [Behavioral practice](behavioral/README.md): answer frameworks and separate explanations.

## Layout

```text
solutions/
  01-arrays-and-hashmaps/
    group-anagrams/
      question.md
      trick.md
      Solution.java
      SolutionDebug.java
      explanation.md
  ... eight more topic sections
system-design/<question>/
  question.md
  trick.md
  solution.md
  explanation.md
behavioral/<question>/
  question.md
  trick.md
  answer-framework.md
  explanation.md
notes/
tests/
```

Start with `question.md` in each problem folder for the prompt, input/output descriptions, and two examples. Design and behavioral prompts use example scenarios instead of a single exact output.

Use `trick.md` for a quick review: the key observation, a line from the solution, a concrete data-structure state, and a short memory cue. Design and behavioral notes use a key move instead of code. Try `question.md` first; use the hint only when needed, and open `explanation.md` for the full reasoning.

Every coding explanation includes the problem, a short ASCII trace, implementation reasoning, complexity, assumptions, and edge cases. Code uses unique Java packages so all 45 classes can compile together. Linked-list, tree, graph, cache, and trie types are nested inside their solution class to keep each question self-contained.

## Read the debug walkthroughs

Each coding question has a `SolutionDebug.java` with the same algorithm and comments showing example values. No print statements or `main` method are added. Match each `LOOP START L1` with `LOOP END L1`; nested loops have their own labels. These mark the code boundaries: an early return, break, or continue can change the path through them. Recursive solutions identify base cases, calls, and how results return to the caller.

Read the comments alongside the statements they describe. The examples come from `question.md`; map iteration order and other non-unique results are called out where relevant. Design and behavioral prompts have no Java loops, so they retain their existing guides.

## Run checks

Install a JDK (Java 8 or newer) and Python 3, then run from the repository root:

```sh
python3 tests/run_tests.py
```

The runner checks that debug copies preserve the original code, compiles both versions, and runs the same assertions against each in a temporary directory. It checks examples and selected edge cases; it is not exhaustive verification.

To compile one solution, for example:

```sh
javac -d /tmp/dsa-classes solutions/01-arrays-and-hashmaps/group-anagrams/Solution.java
```

Solutions expose methods rather than interactive `main` programs. Call methods from a test harness or your IDE. For an online judge, remove the package declaration and adapt the nested node types or class names to its supplied interface. Some sum/count methods return `long` to prevent int overflow; adjust only when the judge's constraints guarantee int results.

## Scope

This collection organizes the supplied question bank. It does not reproduce unverified claims about current hiring processes or candidate reports. System design files are reference approaches, and behavioral files are prompts for your own experience, not invented personal stories.

## Save progress

```sh
git add .
git commit -m "Update practice notes"
```
