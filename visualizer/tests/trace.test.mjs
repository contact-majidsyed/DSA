import test from "node:test";
import assert from "node:assert/strict";
import {
  buildTrace,
  parseInput,
  EXAMPLES,
  INT_MIN,
  INT_MAX,
} from "../src/trace.mjs";

test("first example: inspect map before storing, then return without storing the matched value", () => {
  const trace = buildTrace([2, 7, 11, 15], 9);
  assert.deepEqual(
    trace.map((s) => s.phase),
    [
      "init",
      "visit",
      "need",
      "lookup",
      "store",
      "visit",
      "need",
      "lookup",
      "return",
    ],
  );
  assert.deepEqual(trace[3].entries, []);
  assert.deepEqual(trace[4].entries, [{ value: 2, index: 0 }]);
  assert.equal(trace[7].matchIndex, 0);
  assert.deepEqual(trace.at(-1).pair, [0, 1]);
  assert.deepEqual(trace.at(-1).entries, [{ value: 2, index: 0 }]);
});
test("duplicates use distinct indices, and old snapshots stay unchanged", () => {
  const trace = buildTrace([3, 3], 6);
  assert.deepEqual(trace.at(-1).pair, [0, 1]);
  assert.equal(trace[3].found, false);
  assert.deepEqual(trace[0].entries, []);
});
test("repeated put overwrites the stored index without duplicating map rows", () => {
  const trace = buildTrace([1, 1, 3], 4);
  const secondPut = trace.filter((s) => s.phase === "store")[1];
  assert.equal(secondPut.previousIndex, 0);
  assert.deepEqual(secondPut.entries, [{ value: 1, index: 1 }]);
  assert.deepEqual(trace.at(-1).pair, [1, 2]);
});
test("negative values and int-range guard follow the Java behavior", () => {
  assert.deepEqual(buildTrace([-3, 4, 3], 0).at(-1).pair, [0, 2]);
  const trace = buildTrace([INT_MIN, INT_MAX], INT_MAX);
  assert.equal(trace.find((s) => s.phase === "need").need, 4294967295);
  assert.equal(trace.find((s) => s.phase === "lookup").found, false);
  assert.equal(trace.at(-1).phase, "throw");
});
test("no answer leaves the loop and throws; every built-in example is supported", () => {
  for (const example of EXAMPLES)
    assert.ok(buildTrace(example.nums, example.target).at(-1).terminal);
  const trace = buildTrace([1], 2);
  assert.equal(trace.at(-2).phase, "exhausted");
  assert.equal(trace.at(-1).phase, "throw");
});
test("custom input parsing rejects missing values, decimals, and out-of-range integers", () => {
  assert.deepEqual(parseInput("[3, 2, 4]", "6"), {
    nums: [3, 2, 4],
    target: 6,
  });
  for (const [nums, target] of [
    ["", "9"],
    ["1,,2", "3"],
    ["1.5,2", "3"],
    ["1,2", ""],
    ["2147483648", "0"],
  ]) {
    assert.throws(() => parseInput(nums, target));
  }
});
