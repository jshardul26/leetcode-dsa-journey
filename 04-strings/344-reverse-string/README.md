# 344. Reverse String

## Difficulty
Easy

## Pattern
Strings, Two Pointers

---

## Problem

Write a function that reverses a string. The input is given as an array of characters `char[]`.

You must modify the input array **in-place** with **O(1)** extra memory.

---

## Approach

Use the **Two Pointer** technique.

- Place one pointer at the beginning.
- Place another pointer at the end.
- Swap both characters.
- Move the left pointer forward.
- Move the right pointer backward.
- Continue until both pointers meet.

---

## Algorithm

1. Initialize `left = 0`.
2. Initialize `right = s.length - 1`.
3. While `left < right`:
   - Swap `s[left]` and `s[right]`.
   - Increment `left`.
   - Decrement `right`.
4. Array is now reversed.

---

## Java Solution

```java
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
```

---

## Example

Input:

```text
['h','e','l','l','o']
```

Output:

```text
['o','l','l','e','h']
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

## Concepts Learned

- Two Pointer Technique
- In-place Array Modification
- Character Swapping
- Constant Extra Space
- String as Character Array

---

## Revision Status

✅ Solved Independently
