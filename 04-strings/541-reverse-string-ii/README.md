# 541. Reverse String II

## Difficulty
Easy

## Pattern
Strings, Two Pointers

---

## Problem

Given a string `s` and an integer `k`, reverse the first `k` characters for every `2k` characters counting from the start of the string.

Rules:

- Reverse the first `k` characters for every block of `2k`.
- If fewer than `k` characters remain, reverse all of them.
- If between `k` and `2k` characters remain, reverse only the first `k`.

---

## Approach

1. Convert the string into a character array.
2. Traverse the array in blocks of `2 * k`.
3. For each block:
   - `left = start`
   - `right = min(start + k - 1, n - 1)`
4. Reverse the characters between `left` and `right`.
5. Convert the character array back into a string.

---

## Java Solution

```java
class Solution {
    public String reverseStr(String s, int k) {

        char[] ch = s.toCharArray();

        for (int start = 0; start < ch.length; start += 2 * k) {

            int left = start;
            int right = Math.min(start + k - 1, ch.length - 1);

            while (left < right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;

                left++;
                right--;
            }
        }

        return new String(ch);
    }
}
```

---

## Dry Run

Input

```
s = "abcdefg"
k = 2
```

Character Array

```
a b c d e f g
```

### Block 1

```
a b c d
```

Reverse first 2

```
b a c d
```

### Block 2

```
e f g
```

Reverse first 2

```
f e g
```

Final Output

```
bacdfeg
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

(Java creates a character array using `toCharArray()`.)

---

## Java Methods Used

| Method | Purpose |
|--------|---------|
| `toCharArray()` | Convert String to character array |
| `Math.min()` | Prevent index out of bounds |
| `new String(char[])` | Convert character array back to String |

---

## Concepts Learned

- Two Pointer Technique
- Processing strings in fixed-size blocks
- In-place reversal of a character array
- Safe index handling using `Math.min()`

---

## Revision Status

✅ Solved after hints

