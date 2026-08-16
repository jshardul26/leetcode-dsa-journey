# 392. Is Subsequence

## Difficulty

Easy

---

## Pattern

Strings, Two Pointers

---

## Problem

Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`, otherwise return `false`.

A subsequence is formed by deleting some (or no) characters from `t` without changing the relative order of the remaining characters.

---

## Approach

Use two pointers.

- Pointer `i` traverses string `t`.
- Pointer `j` traverses string `s`.

Whenever characters match, move both pointers.

If they do not match, move only the pointer in `t`.

If pointer `j` reaches the end of `s`, then every character of `s` has been found in order.

---

## Algorithm

1. Initialize two pointers:
   - `i = 0` for `t`
   - `j = 0` for `s`
2. Traverse both strings while both pointers are valid.
3. If `t.charAt(i) == s.charAt(j)`:
   - Move both pointers.
4. Otherwise:
   - Move only pointer `i`.
5. After traversal, return `j == s.length()`.

---

## Java Solution

```java
class Solution {
    public boolean isSubsequence(String s, String t) {

        int n = t.length();
        int m = s.length();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {

            if (t.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == m;
    }
}
```

---

## Example 1

Input

```
s = "abc"
t = "ahbgdc"
```

Output

```
true
```

---

## Example 2

Input

```
s = "axc"
t = "ahbgdc"
```

Output

```
false
```

---

## Dry Run

```
s = "abc"
t = "ahbgdc"
```

```
a == a ✓
i++, j++

h != b
i++

b == b ✓
i++, j++

g != c
i++

d != c
i++

c == c ✓
i++, j++
```

Now

```
j == s.length()
```

Return

```
true
```

---

## Time Complexity

```
O(n)
```

where `n` is the length of `t`.

---

## Space Complexity

```
O(1)
```

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `length()` | Get string length |
| `charAt()` | Access a character |

---

## Concepts Learned

- Two Pointers
- Character Comparison
- Sequential Matching
- String Traversal

---

## Common Mistakes

- Moving both pointers even when characters don't match.
- Comparing the wrong strings.
- Returning `i == n` instead of `j == m`.
- Using `length() - 1` unnecessarily.

---

## Key Insight

- `i` scans the larger string (`t`).
- `j` scans the smaller string (`s`).
- We only move `j` when characters match.
- If `j` reaches the end of `s`, then `s` is a subsequence of `t`.

---

## Revision Status

🟢 Solved Independently

**Reason:**

- Correctly identified the two-pointer pattern.
- Implemented the optimal `O(n)` solution.
- Used the clean final condition `return j == m;`.
