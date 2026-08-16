# 125. Valid Palindrome

## Difficulty

Easy

---

## Pattern

Strings, Two Pointers

---

## Problem

Given a string `s`, determine if it is a palindrome, considering only alphanumeric characters and ignoring letter case.

Return `true` if it is a palindrome, otherwise return `false`.

---

## Approach

1. Traverse the string.
2. Keep only alphanumeric characters.
3. Convert every character to lowercase.
4. Store the cleaned characters in a `StringBuilder`.
5. Use two pointers (`left` and `right`) to compare characters from both ends.
6. If every pair matches, return `true`; otherwise, return `false`.

---

## Algorithm

1. Create an empty `StringBuilder`.
2. Traverse the input string.
3. If the current character is alphanumeric:
   - Convert it to lowercase.
   - Append it to the `StringBuilder`.
4. Initialize two pointers:
   - `left = 0`
   - `right = sb.length() - 1`
5. Compare characters while `left < right`.
6. If any pair differs, return `false`.
7. If the loop completes, return `true`.

---

## Java Solution

```java
class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {

            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
```

---

## Example 1

Input

```
s = "A man, a plan, a canal: Panama"
```

Output

```
true
```

---

## Example 2

Input

```
s = "race a car"
```

Output

```
false
```

---

## Example 3

Input

```
s = " "
```

Output

```
true
```

---

## Dry Run

Input

```
"A man, a plan, a canal: Panama"
```

After removing non-alphanumeric characters and converting to lowercase:

```
amanaplanacanalpanama
```

Compare using two pointers:

```
a == a ✓
m == m ✓
a == a ✓
...
```

All characters match.

Return:

```
true
```

---

## Time Complexity

```
O(n)
```

---

## Space Complexity

```
O(n)
```

Extra space is used for the `StringBuilder`.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `length()` | Get string length |
| `charAt()` | Access a character |
| `append()` | Add character to `StringBuilder` |
| `Character.isLetterOrDigit()` | Check if a character is alphanumeric |
| `Character.toLowerCase()` | Convert uppercase to lowercase |

---

## Concepts Learned

- String Traversal
- Character Utility Methods
- Two Pointers
- StringBuilder
- Case-Insensitive Comparison

---

## Common Mistakes

- Forgetting to convert characters to lowercase.
- Comparing characters before removing punctuation.
- Using `==` to compare strings instead of characters.
- Forgetting to move both pointers after a successful comparison.

---

## Revision Status

🟡 Solved After Minor Hint

**Reason:**
- Correct approach.
- Only missed converting characters to lowercase before comparison.
