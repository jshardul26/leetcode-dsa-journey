# 345. Reverse Vowels of a String

## Difficulty

Easy

---

## Pattern

Strings, Two Pointers

---

## Problem

Given a string `s`, reverse only the vowels in the string and return the resulting string.

The vowels are:

- a
- e
- i
- o
- u
- A
- E
- I
- O
- U

---

## Approach

Use the Two Pointer technique.

- One pointer starts from the beginning.
- One pointer starts from the end.
- Skip non-vowel characters.
- When both pointers point to vowels, swap them.
- Continue until both pointers meet.

---

## Algorithm

1. Convert the string into a character array.
2. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`
3. While `left < right`:
   - If the left character is not a vowel, increment `left`.
   - Else if the right character is not a vowel, decrement `right`.
   - Otherwise:
     - Swap both vowels.
     - Move both pointers.
4. Convert the character array back into a string.
5. Return the answer.

---

## Java Solution

```java
class Solution {

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (!isVowel(arr[left])) {
                left++;
            } 
            else if (!isVowel(arr[right])) {
                right--;
            } 
            else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' ||
               ch == 'O' || ch == 'U';
    }
}
```

---

## Example 1

### Input

```
hello
```

### Output

```
holle
```

---

## Example 2

### Input

```
leetcode
```

### Output

```
leotcede
```

---

## Dry Run

Input

```
hello
```

Pointers

```
h e l l o
  L     R
```

Swap vowels

```
h o l l e
```

Answer

```
holle
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

A character array is created from the input string.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `toCharArray()` | Convert String to character array |
| `length` | Get array length |
| `new String(char[])` | Convert character array back to String |

---

## Concepts Learned

- Two Pointers
- Character Swapping
- Helper Function
- Character Classification

---

## Key Insight

Only vowels are swapped.

All consonants remain in their original positions.

---

## Common Mistakes

- Forgetting uppercase vowels.
- Forgetting to move both pointers after swapping.
- Swapping consonants.
- Returning the character array instead of converting it back to a string.

---

## Revision Status

🟢 Solved Independently
