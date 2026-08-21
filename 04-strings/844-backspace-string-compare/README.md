# 844. Backspace String Compare

## Difficulty

Easy

---

## Pattern

Strings, Two Pointers

---

## Problem

Given two strings `s` and `t`, return `true` if they are equal when both are typed into empty text editors.

The character `'#'` represents a backspace.

---

## Approach

Instead of building the final strings, traverse both strings from right to left.

Maintain a skip counter for each string:

- When a `'#'` is found, increase the skip count.
- When a normal character is found and the skip count is greater than zero, skip that character.
- Otherwise, compare the current valid characters from both strings.

---

## Algorithm

1. Initialize two pointers at the end of both strings.
2. Maintain two skip counters.
3. Find the next valid character in both strings.
4. Compare the characters.
5. If they differ, return `false`.
6. Continue until both strings are processed.
7. Return `true`.

---

## Java Solution

```java
class Solution {
    public boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}
```

---

## Example 1

### Input

```
s = "ab#c"
t = "ad#c"
```

### Output

```
true
```

---

## Example 2

### Input

```
s = "ab##"
t = "c#d#"
```

### Output

```
true
```

---

## Example 3

### Input

```
s = "a#c"
t = "b"
```

### Output

```
false
```

---

## Dry Run

```
Input

s = "ab#c"
t = "ad#c"

Process from right to left

Valid characters:

c == c

Skip b
Skip d

a == a

Return true
```

---

## Time Complexity

```
O(n + m)
```

Each character is processed at most once.

---

## Space Complexity

```
O(1)
```

No extra data structures are used.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `charAt()` | Access a character |
| `length()` | Get string length |

---

## Concepts Learned

- Two Pointers
- Reverse Traversal
- Skip Counter Technique
- Constant Space Algorithm

---

## Key Insight

Process both strings from the end while tracking how many characters should be ignored because of backspaces. This avoids constructing new strings or using stacks.

---

## Common Mistakes

- Traversing from left to right.
- Forgetting to decrement the skip counter.
- Comparing characters before skipping deleted ones.
- Using extra stacks when an O(1) space solution is possible.

---

## Revision Status

🟢 Learned Optimal Solution

**Reason:**

- This problem introduces a less obvious two-pointer pattern using reverse traversal and skip counters.
- Worth revisiting once after a few days to reinforce the technique.
