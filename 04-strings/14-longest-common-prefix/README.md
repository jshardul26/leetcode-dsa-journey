# 14. Longest Common Prefix

## Difficulty

Easy

---

## Pattern

Strings, Character-by-Character Comparison

---

## Problem

Write a function to find the **longest common prefix** string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

---

## Approach

Use the **first string as the reference**.

Compare each character of the first string with the character at the same position in every other string.

If:

- a string becomes shorter than the current index, or
- the characters do not match,

return the prefix collected so far.

Otherwise, continue building the prefix.

---

## Algorithm

1. Create an empty `StringBuilder`.
2. Traverse every character of the first string.
3. Store the current character.
4. Compare it with every other string.
5. If any string:
   - ends before this index, or
   - has a different character,
   return the answer.
6. Otherwise, append the character to the answer.
7. Return the final prefix.

---

## Java Solution

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {

                if (i >= strs[j].length()) {
                    return sb.toString();
                }

                if (strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}
```

---

## Example 1

Input

```
["flower","flow","flight"]
```

Output

```
"fl"
```

---

## Example 2

Input

```
["dog","racecar","car"]
```

Output

```
""
```

---

## Dry Run

Reference String

```
flower
```

Compare each character.

```
Index 0

flower
flow
flight

All have 'f'
```

Prefix

```
f
```

---

```
Index 1

flower
flow
flight

All have 'l'
```

Prefix

```
fl
```

---

```
Index 2

flower
flow
flight

o
o
i
```

Characters differ.

Return

```
fl
```

---

## Time Complexity

```
O(n × m)
```

where:

- `n` = number of strings
- `m` = length of the shortest string checked

---

## Space Complexity

```
O(m)
```

for the `StringBuilder`.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `length()` | Get string length |
| `charAt(index)` | Access a character |
| `append()` | Add a character to `StringBuilder` |
| `toString()` | Convert `StringBuilder` to `String` |

---

## Concepts Learned

- String Traversal
- Nested Loops
- Character-by-Character Comparison
- Boundary Checking
- StringBuilder
- Early Return

---

## Common Mistakes

- Comparing beyond the length of a string.
- Forgetting to check `i >= strs[j].length()`.
- Comparing the first string with itself unnecessarily.
- Creating unnecessary extra `StringBuilder` objects.

---

## Revision Status

🟡 Solved After Hints

**Reason:**

- Understood the overall approach.
- Needed help with nested loop logic.
- Missed the boundary condition (`i >= strs[j].length()`).

**Add to:** Solve Again
