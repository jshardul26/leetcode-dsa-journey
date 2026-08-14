# 58. Length of Last Word

## Difficulty
Easy

## Pattern
Strings, String Traversal

---

## Problem

Given a string `s` consisting of words and spaces, return the length of the last word in the string.

A word is defined as a maximal substring consisting of non-space characters only.

---

## Approach

Instead of using `split()`, traverse the string from the end.

### Steps

1. Start from the last character.
2. Skip all trailing spaces.
3. Count characters until a space or the beginning of the string is reached.
4. Return the count.

This approach avoids creating extra arrays and uses constant extra space.

---

## Algorithm

1. Initialize `count = 0`.
2. Traverse the string from right to left.
3. If trailing spaces are found before counting starts, ignore them.
4. Once counting begins:
   - Continue counting non-space characters.
   - Stop when a space is encountered.
5. Return the count.

---

## Java Solution

```java
class Solution {
    public int lengthOfLastWord(String s) {

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch == ' ' && count == 0) {
                continue;
            }

            if (ch == ' ') {
                return count;
            }

            count++;
        }

        return count;
    }
}
```

---

## Example

### Example 1

Input

```
s = "Hello World"
```

Output

```
5
```

---

### Example 2

Input

```
s = "   fly me   to   the moon  "
```

Output

```
4
```

---

### Example 3

Input

```
s = "a"
```

Output

```
1
```

---

## Dry Run

Input

```
"Hello World   "
```

Traversal from right to left:

```
Skip spaces
↓

H e l l o _ W o r l d _ _ _
                        ↑
```

Count letters:

```
d → 1
l → 2
r → 3
o → 4
W → 5
```

Encounter a space → Return `5`.

---

## Time Complexity

```
O(n)
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
| `charAt(index)` | Access a character at a specific index |

---

## Concepts Learned

- String Traversal
- Reverse Traversal
- Handling Trailing Spaces
- Character Comparison
- Boundary Conditions
- Constant Space Algorithm

---

## Common Mistakes

- Using `split()` instead of traversal.
- Comparing characters using double quotes (`" "`) instead of single quotes (`' '`).
- Forgetting to skip trailing spaces.
- Using `i > 0` instead of `i >= 0`, which skips index `0`.

---

## Revision Status

✅ Solved Independently
