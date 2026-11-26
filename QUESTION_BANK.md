# Question Bank

45 coding questions, five system design prompts, and ten behavioral prompts. LOW = foundational, MEDIUM = common interview-level preparation, HIGH = more challenging preparation. Coding labels retain the supplied plan's tiers; they are not official platform difficulty ratings. Design and behavioral labels estimate preparation effort.

[Study plan](STUDY_PLAN.md) | [Array printing note](notes/java-array-printing.md)

## Arrays and HashMaps

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Two Sum | LOW | HashMap | [Java](solutions/01-arrays-and-hashmaps/two-sum/Solution.java) · [Explanation](solutions/01-arrays-and-hashmaps/two-sum/explanation.md) |
| Group Anagrams | MEDIUM | Frequency signature + HashMap | [Java](solutions/01-arrays-and-hashmaps/group-anagrams/Solution.java) · [Explanation](solutions/01-arrays-and-hashmaps/group-anagrams/explanation.md) |
| Product of Array Except Self | MEDIUM | Prefix / suffix | [Java](solutions/01-arrays-and-hashmaps/product-of-array-except-self/Solution.java) · [Explanation](solutions/01-arrays-and-hashmaps/product-of-array-except-self/explanation.md) |
| Subarray Sum Equals K | MEDIUM | Prefix sum + frequency map | [Java](solutions/01-arrays-and-hashmaps/subarray-sum-equals-k/Solution.java) · [Explanation](solutions/01-arrays-and-hashmaps/subarray-sum-equals-k/explanation.md) |
| Maximum Subarray | MEDIUM | Kadane dynamic programming | [Java](solutions/01-arrays-and-hashmaps/maximum-subarray/Solution.java) · [Explanation](solutions/01-arrays-and-hashmaps/maximum-subarray/explanation.md) |

## Strings and Sliding Window

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Valid Anagram | LOW | Frequency counter | [Java](solutions/02-strings-and-sliding-window/valid-anagram/Solution.java) · [Explanation](solutions/02-strings-and-sliding-window/valid-anagram/explanation.md) |
| Longest Substring Without Repeating Characters | MEDIUM | Sliding window | [Java](solutions/02-strings-and-sliding-window/longest-substring-without-repeating/Solution.java) · [Explanation](solutions/02-strings-and-sliding-window/longest-substring-without-repeating/explanation.md) |
| Longest Palindromic Substring | MEDIUM | Expand around center | [Java](solutions/02-strings-and-sliding-window/longest-palindromic-substring/Solution.java) · [Explanation](solutions/02-strings-and-sliding-window/longest-palindromic-substring/explanation.md) |
| Minimum Window Substring | HIGH | Sliding window + frequency map | [Java](solutions/02-strings-and-sliding-window/minimum-window-substring/Solution.java) · [Explanation](solutions/02-strings-and-sliding-window/minimum-window-substring/explanation.md) |
| Longest Repeating Character Replacement | MEDIUM | Sliding window | [Java](solutions/02-strings-and-sliding-window/character-replacement/Solution.java) · [Explanation](solutions/02-strings-and-sliding-window/character-replacement/explanation.md) |

## Two Pointers and Binary Search

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Valid Palindrome | LOW | Two pointers | [Java](solutions/03-two-pointers-and-binary-search/valid-palindrome/Solution.java) · [Explanation](solutions/03-two-pointers-and-binary-search/valid-palindrome/explanation.md) |
| Container With Most Water | MEDIUM | Greedy two pointers | [Java](solutions/03-two-pointers-and-binary-search/container-with-most-water/Solution.java) · [Explanation](solutions/03-two-pointers-and-binary-search/container-with-most-water/explanation.md) |
| 3Sum | MEDIUM | Sorting + two pointers | [Java](solutions/03-two-pointers-and-binary-search/three-sum/Solution.java) · [Explanation](solutions/03-two-pointers-and-binary-search/three-sum/explanation.md) |
| Search in Rotated Sorted Array | MEDIUM | Modified binary search | [Java](solutions/03-two-pointers-and-binary-search/search-rotated-sorted-array/Solution.java) · [Explanation](solutions/03-two-pointers-and-binary-search/search-rotated-sorted-array/explanation.md) |
| Median of Two Sorted Arrays | HIGH | Binary search partition | [Java](solutions/03-two-pointers-and-binary-search/median-of-two-sorted-arrays/Solution.java) · [Explanation](solutions/03-two-pointers-and-binary-search/median-of-two-sorted-arrays/explanation.md) |

## Linked Lists, Stacks and Queues

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Reverse Linked List | LOW | Pointer manipulation | [Java](solutions/04-linked-lists-stacks-and-queues/reverse-linked-list/Solution.java) · [Explanation](solutions/04-linked-lists-stacks-and-queues/reverse-linked-list/explanation.md) |
| Linked List Cycle | LOW | Fast / slow pointers | [Java](solutions/04-linked-lists-stacks-and-queues/linked-list-cycle/Solution.java) · [Explanation](solutions/04-linked-lists-stacks-and-queues/linked-list-cycle/explanation.md) |
| Valid Parentheses | LOW | Stack | [Java](solutions/04-linked-lists-stacks-and-queues/valid-parentheses/Solution.java) · [Explanation](solutions/04-linked-lists-stacks-and-queues/valid-parentheses/explanation.md) |
| Daily Temperatures | MEDIUM | Monotonic stack | [Java](solutions/04-linked-lists-stacks-and-queues/daily-temperatures/Solution.java) · [Explanation](solutions/04-linked-lists-stacks-and-queues/daily-temperatures/explanation.md) |
| LRU Cache | HIGH | HashMap + doubly linked list | [Java](solutions/04-linked-lists-stacks-and-queues/lru-cache/Solution.java) · [Explanation](solutions/04-linked-lists-stacks-and-queues/lru-cache/explanation.md) |

## Trees and Binary Search Trees

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Maximum Depth of Binary Tree | LOW | Recursive DFS | [Java](solutions/05-trees-and-binary-search-trees/maximum-depth/Solution.java) · [Explanation](solutions/05-trees-and-binary-search-trees/maximum-depth/explanation.md) |
| Binary Tree Level Order Traversal | MEDIUM | BFS queue | [Java](solutions/05-trees-and-binary-search-trees/level-order-traversal/Solution.java) · [Explanation](solutions/05-trees-and-binary-search-trees/level-order-traversal/explanation.md) |
| Validate Binary Search Tree | MEDIUM | DFS with bounds | [Java](solutions/05-trees-and-binary-search-trees/validate-bst/Solution.java) · [Explanation](solutions/05-trees-and-binary-search-trees/validate-bst/explanation.md) |
| Lowest Common Ancestor of a Binary Tree | MEDIUM | Recursive DFS | [Java](solutions/05-trees-and-binary-search-trees/lowest-common-ancestor/Solution.java) · [Explanation](solutions/05-trees-and-binary-search-trees/lowest-common-ancestor/explanation.md) |
| Serialize and Deserialize Binary Tree | HIGH | Preorder encoding | [Java](solutions/05-trees-and-binary-search-trees/serialize-deserialize-tree/Solution.java) · [Explanation](solutions/05-trees-and-binary-search-trees/serialize-deserialize-tree/explanation.md) |

## Graphs and Union Find

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Number of Islands | MEDIUM | Iterative DFS | [Java](solutions/06-graphs-and-union-find/number-of-islands/Solution.java) · [Explanation](solutions/06-graphs-and-union-find/number-of-islands/explanation.md) |
| Clone Graph | MEDIUM | BFS + identity map | [Java](solutions/06-graphs-and-union-find/clone-graph/Solution.java) · [Explanation](solutions/06-graphs-and-union-find/clone-graph/explanation.md) |
| Course Schedule | MEDIUM | Topological sort | [Java](solutions/06-graphs-and-union-find/course-schedule/Solution.java) · [Explanation](solutions/06-graphs-and-union-find/course-schedule/explanation.md) |
| Accounts Merge | MEDIUM | Union Find | [Java](solutions/06-graphs-and-union-find/accounts-merge/Solution.java) · [Explanation](solutions/06-graphs-and-union-find/accounts-merge/explanation.md) |
| Network Delay Time | HIGH | Dijkstra + min-heap | [Java](solutions/06-graphs-and-union-find/network-delay-time/Solution.java) · [Explanation](solutions/06-graphs-and-union-find/network-delay-time/explanation.md) |

## Heaps, Intervals and Greedy Algorithms

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Kth Largest Element in an Array | MEDIUM | Bounded min-heap | [Java](solutions/07-heaps-intervals-and-greedy/kth-largest-element/Solution.java) · [Explanation](solutions/07-heaps-intervals-and-greedy/kth-largest-element/explanation.md) |
| Top K Frequent Elements | MEDIUM | Frequency map + bounded heap | [Java](solutions/07-heaps-intervals-and-greedy/top-k-frequent-elements/Solution.java) · [Explanation](solutions/07-heaps-intervals-and-greedy/top-k-frequent-elements/explanation.md) |
| Merge Intervals | MEDIUM | Sorting | [Java](solutions/07-heaps-intervals-and-greedy/merge-intervals/Solution.java) · [Explanation](solutions/07-heaps-intervals-and-greedy/merge-intervals/explanation.md) |
| Meeting Rooms II | MEDIUM | Sorting + min-heap | [Java](solutions/07-heaps-intervals-and-greedy/meeting-rooms-ii/Solution.java) · [Explanation](solutions/07-heaps-intervals-and-greedy/meeting-rooms-ii/explanation.md) |
| Task Scheduler | HIGH | Greedy frequency formula | [Java](solutions/07-heaps-intervals-and-greedy/task-scheduler/Solution.java) · [Explanation](solutions/07-heaps-intervals-and-greedy/task-scheduler/explanation.md) |

## Dynamic Programming

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Climbing Stairs | LOW | Rolling Fibonacci DP | [Java](solutions/08-dynamic-programming/climbing-stairs/Solution.java) · [Explanation](solutions/08-dynamic-programming/climbing-stairs/explanation.md) |
| House Robber | MEDIUM | Take / skip DP | [Java](solutions/08-dynamic-programming/house-robber/Solution.java) · [Explanation](solutions/08-dynamic-programming/house-robber/explanation.md) |
| Coin Change | MEDIUM | Unbounded amount DP | [Java](solutions/08-dynamic-programming/coin-change/Solution.java) · [Explanation](solutions/08-dynamic-programming/coin-change/explanation.md) |
| Longest Increasing Subsequence | MEDIUM | Binary search over tails | [Java](solutions/08-dynamic-programming/longest-increasing-subsequence/Solution.java) · [Explanation](solutions/08-dynamic-programming/longest-increasing-subsequence/explanation.md) |
| Word Break | MEDIUM | Prefix DP | [Java](solutions/08-dynamic-programming/word-break/Solution.java) · [Explanation](solutions/08-dynamic-programming/word-break/explanation.md) |

## Backtracking, Recursion and Tries

| Question | Difficulty | Pattern | Files |
| --- | --- | --- | --- |
| Subsets | MEDIUM | Backtracking | [Java](solutions/09-backtracking-recursion-and-tries/subsets/Solution.java) · [Explanation](solutions/09-backtracking-recursion-and-tries/subsets/explanation.md) |
| Combination Sum | MEDIUM | Backtracking with reuse | [Java](solutions/09-backtracking-recursion-and-tries/combination-sum/Solution.java) · [Explanation](solutions/09-backtracking-recursion-and-tries/combination-sum/explanation.md) |
| Permutations | MEDIUM | Backtracking with used flags | [Java](solutions/09-backtracking-recursion-and-tries/permutations/Solution.java) · [Explanation](solutions/09-backtracking-recursion-and-tries/permutations/explanation.md) |
| Word Search | MEDIUM | Grid DFS + backtracking | [Java](solutions/09-backtracking-recursion-and-tries/word-search/Solution.java) · [Explanation](solutions/09-backtracking-recursion-and-tries/word-search/explanation.md) |
| Implement Trie | MEDIUM | Prefix tree | [Java](solutions/09-backtracking-recursion-and-tries/implement-trie/Solution.java) · [Explanation](solutions/09-backtracking-recursion-and-tries/implement-trie/explanation.md) |

## System Design

| Question | Difficulty | Files |
| --- | --- | --- |
| Design a URL Shortener | LOW | [Approach](system-design/url-shortener/solution.md) · [Explanation](system-design/url-shortener/explanation.md) |
| Design a Rate Limiter | MEDIUM | [Approach](system-design/rate-limiter/solution.md) · [Explanation](system-design/rate-limiter/explanation.md) |
| Design a Notification System | MEDIUM | [Approach](system-design/notification-system/solution.md) · [Explanation](system-design/notification-system/explanation.md) |
| Design a Chat Application | MEDIUM | [Approach](system-design/chat-application/solution.md) · [Explanation](system-design/chat-application/explanation.md) |
| Design a Distributed Cache | HIGH | [Approach](system-design/distributed-cache/solution.md) · [Explanation](system-design/distributed-cache/explanation.md) |

## Behavioral

| Question | Difficulty | Files |
| --- | --- | --- |
| Tell me about a technically difficult project you led. | HIGH | [Framework](behavioral/difficult-project/answer-framework.md) · [Explanation](behavioral/difficult-project/explanation.md) |
| Tell me about a disagreement with another engineer. | MEDIUM | [Framework](behavioral/engineering-disagreement/answer-framework.md) · [Explanation](behavioral/engineering-disagreement/explanation.md) |
| Describe a time you made a wrong technical decision. | HIGH | [Framework](behavioral/wrong-technical-decision/answer-framework.md) · [Explanation](behavioral/wrong-technical-decision/explanation.md) |
| Tell me about a production incident you handled. | HIGH | [Framework](behavioral/production-incident/answer-framework.md) · [Explanation](behavioral/production-incident/explanation.md) |
| Describe a time you influenced a team without authority. | HIGH | [Framework](behavioral/influence-without-authority/answer-framework.md) · [Explanation](behavioral/influence-without-authority/explanation.md) |
| Tell me about a project that failed. | HIGH | [Framework](behavioral/failed-project/answer-framework.md) · [Explanation](behavioral/failed-project/explanation.md) |
| How do you prioritize technical debt? | MEDIUM | [Framework](behavioral/technical-debt/answer-framework.md) · [Explanation](behavioral/technical-debt/explanation.md) |
| Describe a trade-off between speed and quality. | MEDIUM | [Framework](behavioral/speed-versus-quality/answer-framework.md) · [Explanation](behavioral/speed-versus-quality/explanation.md) |
| How have you mentored another engineer? | MEDIUM | [Framework](behavioral/mentoring/answer-framework.md) · [Explanation](behavioral/mentoring/explanation.md) |
| Tell me about a time you challenged an existing architecture. | HIGH | [Framework](behavioral/challenge-architecture/answer-framework.md) · [Explanation](behavioral/challenge-architecture/explanation.md) |
