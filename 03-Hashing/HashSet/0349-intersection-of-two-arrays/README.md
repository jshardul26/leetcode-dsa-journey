# LeetCode 349 — Intersection of Two Arrays

## Problem

Given two integer arrays `nums1` and `nums2`, return an array containing their intersection.

Each element in the result must be **unique**.

The order of the result does not matter.

### Example

**Input:**

```text
nums1 = [1,2,2,1]
nums2 = [2,2]
```

**Output:**

```text
[2]
```

---

## Approach

We use a **HashSet** to efficiently find the common elements.

### Step 1: Store elements of `nums1`

Add every element of `nums1` into a `HashSet`.

Because a `HashSet` stores only unique values, duplicates are automatically removed.

```text
nums1 = [1,2,2,1]

set = {1,2}
```

### Step 2: Traverse `nums2`

For every element in `nums2`, check whether it exists in the set.

If it exists, add it to another `HashSet` called `result`.

```text
nums2 = [2,2]

result = {2}
```

Using another `HashSet` ensures that the answer also contains no duplicates.

### Step 3: Convert the result

Finally, convert the `HashSet` into an integer array and return it.

---

## Java Code

```java
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        // Store all elements of nums1
        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> result = new HashSet<>();

        // Find common elements
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        // Convert HashSet to int[]
        int[] answer = new int[result.size()];
        int i = 0;

        for (int num : result) {
            answer[i++] = num;
        }

        return answer;
    }
}
```

---

## Complexity Analysis

Let:

* `n` = length of `nums1`
* `m` = length of `nums2`

### Time Complexity

```text
O(n + m)
```

We traverse both arrays once.

`HashSet.contains()` and `HashSet.add()` take **O(1)** average time.

### Space Complexity

```text
O(n + k)
```

where `k` is the number of unique elements in the intersection.

---

## Key Pattern

**HashSet / Hashing**

This problem is a good example of using a `HashSet` when we need to:

* Check whether an element exists
* Remove duplicates
* Find common elements between collections

### Pattern to remember

```text
Array → HashSet → contains() → Result
```

---

## Important Java Methods

| Method            | Purpose                           |
| ----------------- | --------------------------------- |
| `set.add(x)`      | Adds an element                   |
| `set.contains(x)` | Checks if element exists          |
| `set.size()`      | Returns number of unique elements |

---

## Related Problems

* LeetCode 217 — Contains Duplicate
* LeetCode 242 — Valid Anagram
* LeetCode 349 — Intersection of Two Arrays
* LeetCode 350 — Intersection of Two Arrays II
* LeetCode 128 — Longest Consecutive Sequence

