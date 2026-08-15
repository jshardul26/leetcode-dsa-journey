# 28. Find the Index of the First Occurrence in a String

## Difficulty

Easy

---

## Pattern

Strings, Brute Force String Matching

---

## Problem

Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`.

If `needle` is not part of `haystack`, return `-1`.

---

## Approach

Use the brute-force string matching approach.

For every possible starting position in `haystack`:

1. Assume the strings match.
2. Compare every character of `needle`.
3. If any character differs:
   - Mark the match as false.
   - Stop comparing.
4. If every character matches, return the starting index.
5. If no match is found after checking every position, return `-1`.

---

## Algorithm

1. Handle the edge case where `needle` is empty.
2. Iterate over every valid starting position in `haystack`.
3. Compare characters using:
   - `haystack.charAt(i + j)`
   - `needle.charAt(j)`
4. Break immediately when a mismatch occurs.
5. Return the first matching index.
6. Return `-1` if no match exists.

---

## Java Solution

```java
class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            boolean match = true;

            for (int j = 0; j < needle.length(); j++) {

                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return i;
            }
        }

        return -1;
    }
}
```

---

## Dry Run

### Input

```
haystack = "hello"
needle = "ll"
```

### Start at index 0

```
hello
^^

ll
```

Mismatch.

---

### Start at index 1

```
hello
 ^^

ll
```

Mismatch.

---

### Start at index 2

```
hello
  ^^

ll
```

Comparisons:

```
haystack[2] == needle[0]
l == l ✅

haystack[3] == needle[1]
l == l ✅
```

Return:

```
2
```

---

## Example

### Example 1

Input

```
haystack = "sadbutsad"
needle = "sad"
```

Output

```
0
```

---

### Example 2

Input

```
haystack = "leetcode"
needle = "leeto"
```

Output

```
-1
```

---

## Time Complexity

```
O((n - m + 1) × m)
```

- `n` = length of `haystack`
- `m` = length of `needle`

Worst case:

```
O(n × m)
```

---

## Space Complexity

```
O(1)
```

---

## Java Methods Used

| Method | Purpose |
|----------|---------|
| `length()` | Get string length |
| `charAt()` | Access a character |

---

## Concepts Learned

- Nested Loops
- Brute Force String Matching
- Character-by-Character Comparison
- Early Exit (`break`)
- Boundary Checking
- Boolean Flag

---

## Common Mistakes

- Using `contains()` or `indexOf()` instead of implementing the algorithm.
- Comparing only one character and returning immediately.
- Forgetting to use `i + j` while traversing the `haystack`.
- Letting the outer loop go beyond the last valid starting position.
- Not breaking after a mismatch.

---

## Key Insight

- `i` = Starting index in the `haystack`.
- `j` = Current index in the `needle`.
- `i + j` = Current character being compared in the `haystack`.

This `i + j` indexing is the foundation of brute-force string matching.

---

## Revision Status

🟡 Solved After Hints

**Reason:**
- Understood the nested loop approach.
- Needed help with:
  - `i + j` indexing.
  - Correct outer loop boundary.
  - Using a boolean flag.
  - Breaking on mismatch.

**Add to:** Solve Again
