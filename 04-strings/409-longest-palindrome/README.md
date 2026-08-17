# 409. Longest Palindrome

## Difficulty

Easy

---

## Pattern

Strings, Frequency Array

---

## Problem

Given a string `s` which consists of lowercase and/or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case-sensitive.

---

## Approach

Since the string contains only English letters (uppercase and lowercase), use a frequency array of size `128` (ASCII).

1. Count the frequency of every character.
2. Every even frequency can be used completely.
3. Every odd frequency contributes `frequency - 1`.
4. If at least one odd frequency exists, place one odd character in the center.

---

## Algorithm

1. Create an integer array of size `128`.
2. Count the frequency of every character.
3. Traverse the frequency array.
4. If frequency is even:
   - Add the complete frequency.
5. Otherwise:
   - Add `frequency - 1`.
   - Mark that an odd frequency exists.
6. If an odd frequency exists, add `1`.
7. Return the total length.

---

## Java Solution

```java
class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        int count = 0;
        boolean hasOdd = false;

        for (int i = 0; i < freq.length; i++) {

            if (freq[i] % 2 == 0) {
                count += freq[i];
            } else {
                count += freq[i] - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            count++;
        }

        return count;
    }
}
```

---

## Example 1

Input

```
s = "abccccdd"
```

Output

```
7
```

Explanation

```
dccaccd
```

Length = 7

---

## Example 2

Input

```
s = "a"
```

Output

```
1
```

---

## Example 3

Input

```
s = "ccc"
```

Output

```
3
```

---

## Dry Run

Input

```
s = "abccccdd"
```

Frequency

```
a → 1
b → 1
c → 4
d → 2
```

Contribution

```
a → 0
b → 0
c → 4
d → 2
```

Current length

```
6
```

Odd frequencies exist

```
+1
```

Answer

```
7
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

The frequency array size is fixed (`128`).

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `length()` | Get string length |
| `charAt()` | Access a character |

---

## Concepts Learned

- Frequency Array
- ASCII Character Mapping
- Even and Odd Frequencies
- Greedy Construction of a Palindrome

---

## Key Insight

Every character with:

- Even frequency → use all occurrences.
- Odd frequency → use `frequency - 1`.

Finally, if any odd frequency exists, place exactly one odd character in the center.

---

## Common Mistakes

- Using an array of size `26` or `52` instead of `128`.
- Using `char[]` instead of `int[]` for counting frequencies.
- Forgetting to add one character to the center.
- Incorrect loop condition (`for(int i = 0; ch.length; i++)`).

---

## Revision Status

🟢 Solved Independently (Frequency Array Version)

**Reason:**

- Correctly recognized the frequency-array approach.
- Only minor Java syntax mistakes (array size, type, and loop condition).
- Core algorithm was correct.
