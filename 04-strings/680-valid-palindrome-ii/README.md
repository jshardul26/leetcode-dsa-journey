# 680. Valid Palindrome II

## Difficulty

Easy

---

## Pattern

Strings, Two Pointers

---

## Problem

Given a string `s`, return `true` if it can become a palindrome after deleting **at most one character**.

---

## Approach

Use two pointers from both ends of the string.

- If characters match, move both pointers inward.
- At the first mismatch, try:
  - Skipping the left character.
  - Skipping the right character.
- If either remaining substring is a palindrome, return `true`.

---

## Algorithm

1. Initialize two pointers:
   - `left = 0`
   - `right = s.length() - 1`
2. While `left < right`:
   - If characters match, move both pointers.
   - Otherwise:
     - Check if `left + 1 ... right` is a palindrome.
     - Check if `left ... right - 1` is a palindrome.
     - Return `true` if either check succeeds.
3. If the loop completes, the string is already a palindrome.

---

## Java Solution

```java
class Solution {

    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right)
                        || isPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
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
s = "aba"
```

Output

```
true
```

---

## Example 2

Input

```
s = "abca"
```

Output

```
true
```

Explanation

```
Delete 'c'

aba
```

---

## Example 3

Input

```
s = "abc"
```

Output

```
false
```

---

## Dry Run

Input

```
abca
```

Pointers

```
a b c a
L     R
```

Characters match.

Move inward.

```
a b c a
  L R
```

Mismatch:

```
b != c
```

Try:

```
Skip b

aca
```

Palindrome ✅

Return

```
true
```

---

## Time Complexity

```
O(n)
```

Only one full traversal is performed, with at most two additional bounded palindrome checks. :contentReference[oaicite:0]{index=0}

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
- Helper Function
- Greedy Decision
- Palindrome Checking

---

## Key Insight

At the **first mismatch**, there are only **two possible valid choices**:

- Skip the left character.
- Skip the right character.

If either remaining substring is a palindrome, the answer is `true`.

---

## Common Mistakes

- Comparing only the next character instead of checking the whole remaining substring.
- Trying to continue after the first mismatch.
- Using a deletion counter unnecessarily.
- Forgetting to handle strings that are already palindromes.

---

## Revision Status

🟡 Solve Again

**Reason:**

- Correctly identified the two-pointer approach.
- Needed guidance to recognize that the remaining **entire substring** must be validated using a helper function instead of checking only adjacent characters.
