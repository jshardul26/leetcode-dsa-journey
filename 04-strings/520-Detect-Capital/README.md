# 520. Detect Capital

## Difficulty

Easy

---

## Pattern

Strings, Character Traversal

---

## Problem

We define the usage of capitals in a word to be correct if one of the following holds:

- All letters are uppercase.
- All letters are lowercase.
- Only the first letter is uppercase.

Return `true` if the given word uses capitals correctly.

---

## Approach

Count the number of uppercase letters in the word.

Then check the three valid cases:

1. Every letter is uppercase.
2. No letter is uppercase.
3. Exactly one uppercase letter, and it is the first character.

---

## Algorithm

1. Initialize `upperCount = 0`.
2. Traverse the string.
3. Count uppercase letters using `Character.isUpperCase()`.
4. Return `true` if:
   - `upperCount == word.length()`
   - `upperCount == 0`
   - `upperCount == 1` and first character is uppercase.
5. Otherwise return `false`.

---

## Java Solution

```java
class Solution {
    public boolean detectCapitalUse(String word) {

        int upperCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCount++;
            }
        }

        if (upperCount == word.length()) {
            return true;
        }

        if (upperCount == 0) {
            return true;
        }

        if (upperCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}
```

---

## Example 1

### Input

```
word = "USA"
```

### Output

```
true
```

---

## Example 2

### Input

```
word = "Google"
```

### Output

```
true
```

---

## Example 3

### Input

```
word = "FlaG"
```

### Output

```
false
```

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
|---------|---------|
| `charAt()` | Access a character |
| `length()` | Get string length |
| `Character.isUpperCase()` | Check if a character is uppercase |

---

## Concepts Learned

- String Traversal
- Character Classification
- Counting
- Conditional Logic

---

## Key Insight

Only **three capitalization patterns** are valid:

- All uppercase
- All lowercase
- Only the first letter uppercase

Any other combination is invalid.

---

## Common Mistakes

- Forgetting to check whether the single uppercase letter is the first character.
- Using ASCII values instead of `Character.isUpperCase()`.
- Not handling one-letter words.

---

## Revision Status

🟢 Good to Go
