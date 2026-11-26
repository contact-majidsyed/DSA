# Printing Arrays in Java

```java
import java.util.Arrays;

int[] nums = {2, 7, 11, 15};
System.out.println(Arrays.toString(nums)); // [2, 7, 11, 15]

for (int num : nums) {
    System.out.println(num); // one number per line
}

int[][] matrix = {{1, 2}, {3, 4}};
System.out.println(Arrays.deepToString(matrix)); // [[1, 2], [3, 4]]
```

Place these statements inside a method, such as `main`. Printing `nums` directly does not print its elements. Use `Arrays.toString` for a one-dimensional primitive array and `Arrays.deepToString` for nested arrays.

```text
int[] count -> Arrays.toString(count) -> String
 [1,0,...]                              "[1, 0, ...]"
```

The ellipsis above abbreviates the display; the actual string includes every entry. [Group Anagrams](../solutions/01-arrays-and-hashmaps/group-anagrams/explanation.md) uses this complete string as a frequency key. Printing that key is optional debugging, so the solution does not print it on every iteration.
