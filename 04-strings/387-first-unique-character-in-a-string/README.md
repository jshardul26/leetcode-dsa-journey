# 387. First Unique Character in a String

## Difficulty

Easy

---

## Pattern

Strings, Frequency Array

---

## Problem

Given a string `s`, find the first non-repeating character in it and return its index.

If it does not exist, return `-1`.

---

## Approach

Since the string contains only lowercase English letters, use a frequency array of size `26`.

1. Count the frequency of every character.
2. Traverse the string again.
3. Return the index of the first character whose frequency is `1`.
4. If no unique character exists, return `-1`.

---

## Algorithm

1. Create an integer array of size `26`.
2. Count the frequency of every character.
3. Traverse the string again.
4. If the current character has frequency `1`, return its index.
5. If no unique character exists, return `-1`.

---

## Java Solution

```java
class Solution {
    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find first unique character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
```

---

## Example 1

Input

```
s = "leetcode"
```

Output

```
0
```

---

## Example 2

Input

```
s = "loveleetcode"
```

Output

```
2
```

---

## Example 3

Input

```
s = "aabb"
```

Output

```
-1
```

---

## Dry Run

Input

```
s = "loveleetcode"
```

### Frequency Count

```
l → 2
o → 2
v → 1
e → 4
t → 1
c → 1
d → 1
```

### Second Traversal

```
l ❌
o ❌
v ✅
```

Return

```
2
```

---

## Time Complexity

```
O(n)
```

Two traversals of the string.

---

## Space Complexity

```
O(1)
```

The frequency array always contains **26** elements.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `length()` | Get string length |
| `charAt()` | Access a character |

---

## Concepts Learned

- Frequency Array
- Character Counting
- Two-Pass Traversal
- Character-to-Index Mapping (`ch - 'a'`)

---

## Key Insight

The frequency array tells **how many times** each character appears.

The second traversal preserves the original order, allowing us to return the **first** unique character.

---

## Common Mistakes

- Returning the alphabet index instead of the string index.
- Using `char[]` instead of `int[]` for frequency counting.
- Traversing the frequency array instead of the original string.
- Forgetting to return `-1` if no unique character exists.

---

## Revision Status

🟢 Solved Independently

**Reason:**

- Correctly identified the frequency-array pattern.
- Used the optimal two-pass solution.
- Fixed the implementation issue by replacing `char[]` with `int[]`.
