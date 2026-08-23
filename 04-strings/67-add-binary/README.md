# 67. Add Binary

## Difficulty

Easy

---

## Pattern

Strings, Simulation

---

## Problem

Given two binary strings `a` and `b`, return their sum as a binary string.

---

## Approach

Simulate binary addition from right to left.

- Traverse both strings from the last character.
- Maintain a `carry`.
- Add corresponding bits and the carry.
- Append the resulting bit to a `StringBuilder`.
- Reverse the result at the end.

---

## Algorithm

1. Initialize two pointers at the end of both strings.
2. Initialize `carry = 0`.
3. While either string has characters left or there is a carry:
   - Add the carry.
   - Add the current bit from `a` if available.
   - Add the current bit from `b` if available.
   - Append `sum % 2` to the answer.
   - Update `carry = sum / 2`.
4. Reverse the `StringBuilder`.
5. Return the final string.

---

## Java Solution

```java
class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);

            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}
```

---

## Example 1

### Input

```
a = "11"
b = "1"
```

### Output

```
"100"
```

---

## Example 2

### Input

```
a = "1010"
b = "1011"
```

### Output

```
"10101"
```

---

## Dry Run

Input:

```
a = "1010"
b = "1011"
```

```
0 + 1 = 1
Append 1

1 + 1 = 2
Append 0
Carry = 1

Carry + 0 + 0 = 1
Append 1

1 + 1 = 2
Append 0
Carry = 1

Append remaining carry

Reverse

10101
```

---

## Time Complexity

```
O(max(n, m))
```

---

## Space Complexity

```
O(max(n, m))
```

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `charAt()` | Access a character |
| `length()` | Get string length |
| `append()` | Add a digit to `StringBuilder` |
| `reverse()` | Reverse the built string |
| `toString()` | Convert `StringBuilder` to `String` |

---

## Concepts Learned

- String Simulation
- Binary Addition
- Carry Handling
- Right-to-Left Traversal
- Character-to-Integer Conversion

---

## Key Insight

Treat binary addition exactly like decimal addition, except each digit can only be `0` or `1`.

At each step:

```
sum = carry + bitA + bitB
```

Append:

```
sum % 2
```

Update:

```
carry = sum / 2
```

---

## Common Mistakes

- Using `Integer.parseInt()` (fails for long binary strings).
- Forgetting to process the remaining carry.
- Forgetting to reverse the `StringBuilder`.
- Traversing from left to right.

---

## Revision Status

🟡 Solve Again

**Reason:**

- Initially attempted integer conversion instead of binary simulation.
- Important interview pattern for string arithmetic problems.
