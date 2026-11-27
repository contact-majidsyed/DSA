export const INT_MIN = -2147483648;
export const INT_MAX = 2147483647;

export const JAVA = [
  "public int[] twoSum(int[] nums, int target) {",
  "    Map<Integer, Integer> seen = new HashMap<>();",
  "    for (int i = 0; i < nums.length; i++) {",
  "        long need = (long) target - nums[i];",
  "        if (need >= Integer.MIN_VALUE &&",
  "            need <= Integer.MAX_VALUE &&",
  "            seen.containsKey((int) need)) {",
  "            return new int[]{seen.get((int) need), i};",
  "        }",
  "        seen.put(nums[i], i);",
  "    }",
  '    throw new IllegalArgumentException("No pair found");',
  "}",
];

export const EXAMPLES = [
  { label: "Example 1 · find a pair", nums: [2, 7, 11, 15], target: 9 },
  { label: "Example 2 · equal values", nums: [3, 3], target: 6 },
  { label: "More map entries", nums: [3, 2, 4], target: 6 },
  { label: "No pair · exception path", nums: [1, 2, 4], target: 8 },
];

export function validateInput(nums, target) {
  if (!Array.isArray(nums) || nums.length < 1 || nums.length > 12) {
    throw new Error("Use 1–12 numbers so each step stays readable.");
  }
  if (
    ![...nums, target].every(
      (n) => Number.isInteger(n) && n >= INT_MIN && n <= INT_MAX,
    )
  ) {
    throw new Error("Use whole numbers between -2147483648 and 2147483647.");
  }
}

export function parseInput(text, targetText) {
  const clean = text.trim().replace(/^\[/, "").replace(/\]$/, "");
  const parts = clean.split(",").map((s) => s.trim());
  if (
    parts.some((s) => !/^[+-]?\d+$/.test(s)) ||
    !/^[+-]?\d+$/.test(targetText.trim())
  ) {
    throw new Error(
      "Enter comma-separated whole numbers and a whole-number target.",
    );
  }
  const nums = parts.map(Number);
  const target = Number(targetText);
  validateInput(nums, target);
  return { nums, target };
}

// One snapshot per meaningful Java statement. Snapshots own their arrays, so
// moving backward never mutates a later step. Java int subtraction in a long
// is exact here: the largest possible difference is within JS safe integers.
export function buildTrace(nums, target) {
  validateInput(nums, target);
  const seen = new Map();
  const steps = [];
  const emit = (step) =>
    steps.push({
      i: null,
      value: null,
      need: null,
      pair: null,
      matchIndex: null,
      stored: null,
      previousIndex: null,
      terminal: false,
      entries: [...seen].map(([value, index]) => ({ value, index })),
      ...step,
    });
  emit({
    phase: "init",
    lines: [2],
    title: "Create an empty map",
    detail:
      "seen stores a number as the key and its earlier array index as the value. No numbers have been visited yet.",
  });
  for (let i = 0; i < nums.length; i++) {
    const value = nums[i];
    const need = target - value;
    const state = { i, value };
    emit({
      ...state,
      phase: "visit",
      lines: [3],
      title: `Visit index ${i}: value ${value}`,
      detail: `The loop condition ${i} < ${nums.length} is true. Read nums[${i}]. The map still contains only earlier visits.`,
    });
    emit({
      ...state,
      need,
      phase: "need",
      lines: [4],
      title: `Find the missing partner: ${need}`,
      detail: `${target} − (${value}) = ${need}. This is a number to look up, not an array index.`,
    });
    const inRange = need >= INT_MIN && need <= INT_MAX;
    const found = inRange && seen.has(need);
    emit({
      ...state,
      need,
      phase: "lookup",
      lines: [5, 6, 7],
      found,
      matchIndex: found ? seen.get(need) : null,
      title: found
        ? `Found ${need} in seen`
        : inRange
          ? `${need} is not in seen`
          : "The partner is outside the Java int range",
      detail: found
        ? `seen.get(${need}) is ${seen.get(need)}. That earlier index and current index ${i} are two distinct positions.`
        : inRange
          ? `The condition is false. Do not return yet; the next statement saves ${value} at index ${i}.`
          : "The range check is false, so Java skips containsKey. No int array element can equal this partner.",
    });
    if (found) {
      const pair = [seen.get(need), i];
      emit({
        ...state,
        need,
        phase: "return",
        lines: [8],
        pair,
        matchIndex: pair[0],
        terminal: true,
        title: `Return indices [${pair.join(", ")}]`,
        detail: `nums[${pair[0]}] + nums[${pair[1]}] = ${nums[pair[0]]} + (${value}) = ${target}. Return exits the method immediately; the current value is not added to the map.`,
      });
      return steps;
    }
    const previousIndex = seen.has(value) ? seen.get(value) : null;
    seen.set(value, i);
    emit({
      ...state,
      need,
      phase: "store",
      lines: [10],
      stored: value,
      previousIndex,
      title: `Store seen.put(${value}, ${i})`,
      detail:
        previousIndex === null
          ? `Add key ${value} → index ${i}. A later number can now find this value. The loop will increment i next.`
          : `Key ${value} already mapped to index ${previousIndex}; put replaces it with index ${i}. The lookup happened first, so an element cannot pair with itself.`,
    });
  }
  emit({
    phase: "exhausted",
    lines: [3],
    i: nums.length,
    title: "The loop condition is now false",
    detail: `i is ${nums.length}; ${nums.length} < ${nums.length} is false. There is no current array element. Execution leaves the loop.`,
  });
  emit({
    phase: "throw",
    lines: [12],
    terminal: true,
    title: "Throw “No pair found”",
    detail:
      "This input has no answer. The Java method throws an exception; it does not return an empty array. The original question assumes one pair exists.",
  });
  return steps;
}
