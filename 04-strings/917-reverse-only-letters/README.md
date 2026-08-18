# 917. Reverse Only Letters

## Difficulty

Easy

---

## Pattern

Strings, Two Pointers

---

## Problem

Given a string `s`, reverse only the English letters while keeping all non-letter characters in their original positions.

---

## Approach

Use two pointers:

- One pointer starts from the beginning.
- The other starts from the end.
- Skip non-letter characters.
- When both pointers point to letters, swap them.
- Continue until the pointers meet.

---

## Algorithm

1. Convert the string into a character array.
2. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`
3. While `left < right`:
   - If the left character is not a letter, move `left`.
   - Else if the right character is not a letter, move `right`.
   - Otherwise, swap the letters and move both pointers.
4. Return the modified character array as a string.

---

## Java Solution

```java
class Solution {
    public String reverseOnlyLetters(String s) {

        char[] ch = s.toCharArray();

        int i = 0;
        int j = ch.length - 1;

        while (i < j) {

            if (!Character.isLetter(ch[i])) {
                i++;
            } 
            else if (!Character.isLetter(ch[j])) {
                j--;
            } 
            else {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;

                i++;
                j--;
            }
        }

        return new String(ch);
    }
}
```

---

## Example

### Input

```
s = "a-bC-dEf-ghIj"
```

### Output

```
"j-Ih-gfE-dCba"
```

---

## Dry Run

```
Input:
a-bC-dEf-ghIj

Swap:
a ↔ j
b ↔ I
C ↔ h
d ↔ g
E ↔ f

Result:
j-Ih-gfE-dCba
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

(`char[]` created from the input string.)

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `toCharArray()` | Convert string to character array |
| `Character.isLetter()` | Check whether a character is a letter |
| `length` | Get array length |
| `new String(char[])` | Convert character array back to string |

---

## Concepts Learned

- Two Pointers
- Character Swapping
- Character Classification
- In-place Array Manipulation

---

## Key Insight

Move both pointers inward while skipping non-letter characters. Only letters are swapped, so all special characters remain in their original positions.

---

## Common Mistakes

- Using `Character.isLetterOrDigit()` instead of `Character.isLetter()`.
- Forgetting to move both pointers after swapping.
- Swapping non-letter characters.
- Forgetting to convert the character array back to a string.

---

## Revision Status

🟢 Solved with Minor Hint

**Reason:**

- Correctly identified the two-pointer approach.
- Only needed minor corrections:
  - Use `Character.isLetter()`.
  - Increment/decrement pointers after swapping.
