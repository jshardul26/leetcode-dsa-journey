# 459. Repeated Substring Pattern

## Difficulty

Easy

---

## Pattern

Strings, Brute Force, String Construction

---

## Problem

Given a string `s`, determine whether it can be formed by repeating one of its substrings multiple times.

Return `true` if possible; otherwise, return `false`.

---

## Approach

A repeating substring must have a length that divides the total string length.

1. Try every possible substring length from `1` to `n / 2`.
2. Skip lengths that do not divide the total length.
3. Extract the candidate substring.
4. Rebuild the string by repeating the candidate.
5. Compare the rebuilt string with the original.

If any candidate matches, return `true`.

---

## Algorithm

1. Let `n = s.length()`.
2. Iterate `len` from `1` to `n / 2`.
3. If `n % len != 0`, continue.
4. Extract `pattern = s.substring(0, len)`.
5. Repeat `pattern` exactly `n / len` times using a `StringBuilder`.
6. If the built string equals the original string, return `true`.
7. Otherwise continue checking.
8. If no pattern works, return `false`.

---

## Java Solution

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        for (int len = 1; len <= n / 2; len++) {

            if (n % len != 0) {
                continue;
            }

            String pattern = s.substring(0, len);

            StringBuilder sb = new StringBuilder();

            int times = n / len;

            for (int i = 0; i < times; i++) {
                sb.append(pattern);
            }

            if (sb.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
```

---

## Example 1

### Input

```
s = "abab"
```

### Output

```
true
```

Explanation:

```
"ab" + "ab"
```

---

## Example 2

### Input

```
s = "aba"
```

### Output

```
false
```

---

## Example 3

### Input

```
s = "abcabcabcabc"
```

### Output

```
true
```

Explanation:

```
"abc" × 4
```

---

## Dry Run

Input

```
s = "abcabcabc"
```

```
Length = 9

Try len = 1

Pattern = "a"

aaaaaaaaa

Not Equal
```

```
Try len = 2

9 % 2 != 0

Skip
```

```
Try len = 3

Pattern = "abc"

abcabcabc

Equal

Return true
```

---

## Time Complexity

```
O(n²)
```

- Outer loop checks candidate substring lengths.
- Building the repeated string takes up to `O(n)`.

---

## Space Complexity

```
O(n)
```

Due to the `StringBuilder`.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `length()` | Get string length |
| `substring()` | Extract candidate substring |
| `append()` | Add pattern repeatedly |
| `toString()` | Convert `StringBuilder` to `String` |
| `equals()` | Compare two strings |

---

## Concepts Learned

- String Construction
- Brute Force
- Divisibility Check
- Pattern Repetition
- StringBuilder

---

## Key Insight

If a string is made by repeating a substring, then the substring's length **must divide** the total string length. Testing only those valid lengths greatly reduces unnecessary work.

---

## Common Mistakes

- Trying substring lengths larger than `n / 2`.
- Forgetting to check `n % len == 0`.
- Comparing with `==` instead of `equals()`.
- Forgetting to reset the `StringBuilder` for each candidate pattern.

---

## Revision Status

🟡 Solve Again

**Reason:**

- Requires recognizing the divisibility observation.
- Good practice with `substring()` and `StringBuilder`.
- Reinforces brute-force pattern checking before learning the optimized KMP solution.
