# 242. Valid Anagram

## Difficulty

Easy

---

## Pattern

Strings, Frequency Array

---

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, otherwise return `false`.

An anagram is a word formed by rearranging the letters of another word using all the original letters exactly once.

---

## Approach

Since the strings contain only lowercase English letters, use a frequency array of size `26`.

1. If the lengths are different, return `false`.
2. Count the frequency of every character in `s`.
3. Traverse `t` and decrease the corresponding frequency.
4. If any frequency becomes negative, return `false`.
5. If all frequencies become `0`, the strings are anagrams.

---

## Algorithm

1. Compare the lengths of both strings.
2. Create an integer array of size `26`.
3. Increment the frequency for each character in `s`.
4. Decrement the frequency for each character in `t`.
5. If any frequency becomes negative, return `false`.
6. Return `true` after all characters are processed.

---

## Java Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;

            if (freq[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
```

---

## Example 1

Input

```
s = "anagram"
t = "nagaram"
```

Output

```
true
```

---

## Example 2

Input

```
s = "rat"
t = "car"
```

Output

```
false
```

---

## Dry Run

Input

```
s = "anagram"
t = "nagaram"
```

Frequency after processing `s`:

```
a → 3
n → 1
g → 1
r → 1
m → 1
```

Process `t`:

```
n → 0
a → 2
g → 0
a → 1
r → 0
a → 0
m → 0
```

All frequencies become `0`.

Return:

```
true
```

---

## Time Complexity

```
O(n)
```

where `n` is the length of the strings.

---

## Space Complexity

```
O(1)
```

The frequency array always contains exactly **26** elements.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `length()` | Get string length |
| `charAt()` | Access characters |

---

## Concepts Learned

- Frequency Array
- Character Counting
- ASCII Character Mapping
- Comparing Character Frequencies

---

## Key Insight

Map each lowercase character to an index:

```java
index = ch - 'a';
```

```
'a' → 0
'b' → 1
'c' → 2
...
'z' → 25
```

Increment for the first string and decrement for the second string.

If every frequency returns to `0`, the strings are anagrams.

---

## Common Mistakes

- Forgetting to compare string lengths first.
- Using `97` instead of `'a'`.
- Forgetting to decrement the frequency.
- Not checking if a frequency becomes negative.
- Using a `HashMap` when a fixed-size array is sufficient.

---

## Revision Status

🟢 Solved Independently

**Reason:**
- Successfully converted the HashMap solution into a frequency-array solution.
- Correctly used character-to-index mapping.
- Understood when to use an array instead of a HashMap.
