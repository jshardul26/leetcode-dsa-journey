# 415. Add Strings

## Difficulty

Easy

---

## Pattern

Strings, Two Pointers, Simulation

---

## Problem

Given two non-negative integers represented as strings `num1` and `num2`, return their sum as a string.

**Constraints:**

- Do not use `BigInteger`.
- Do not convert the entire string to an integer.

---

## Approach

Simulate the addition process exactly as we do on paper.

- Start from the last digit of both strings.
- Add corresponding digits along with the carry.
- Append the current digit (`sum % 10`) to a `StringBuilder`.
- Update the carry (`sum / 10`).
- Reverse the final string before returning.

---

## Algorithm

1. Initialize two pointers at the end of both strings.
2. Initialize `carry = 0`.
3. While either pointer is valid or carry is non-zero:
   - Read current digits.
   - Compute the sum.
   - Append `sum % 10`.
   - Update `carry = sum / 10`.
4. Reverse the `StringBuilder`.
5. Return the result.

---

## Java Solution

```java
class Solution {
    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {

            int digit1 = 0;
            int digit2 = 0;

            if (i >= 0) {
                digit1 = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                digit2 = num2.charAt(j) - '0';
                j--;
            }

            int sum = digit1 + digit2 + carry;

            sb.append(sum % 10);

            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
```

---

## Example

### Input

```
num1 = "456"
num2 = "77"
```

### Output

```
"533"
```

---

## Dry Run

```
456
 77
----
```

Step 1

```
6 + 7 = 13

Digit = 3
Carry = 1
```

Step 2

```
5 + 7 + 1 = 13

Digit = 3
Carry = 1
```

Step 3

```
4 + 0 + 1 = 5

Digit = 5
Carry = 0
```

StringBuilder

```
335
```

Reverse

```
533
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
| `length()` | Get string length |
| `charAt()` | Access a character |
| `append()` | Add digit to `StringBuilder` |
| `reverse()` | Reverse the final answer |
| `toString()` | Convert `StringBuilder` to `String` |

---

## Concepts Learned

- Two Pointers
- String Simulation
- Carry Handling
- Character to Integer Conversion (`ch - '0'`)
- StringBuilder

---

## Common Mistakes

- Converting the whole string into an integer.
- Forgetting to process the final carry.
- Forgetting to reverse the answer.
- Not handling strings of different lengths.

---

## Revision Status

🟡 Solve Again

**Reason:**

- Initially attempted to convert the entire string into integers.
- Needed guidance to understand the digit-by-digit addition simulation.
- Should revisit to become comfortable with the two-pointer + carry approach.
