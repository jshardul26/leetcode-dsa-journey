# 383. Ransom Note

## Difficulty

Easy

---

## Pattern

Strings, Frequency Array

---

## Problem

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed using the letters from `magazine`.

Each character in `magazine` can only be used once.

---

## Approach

Since all characters are lowercase English letters (`a-z`), use a frequency array of size `26`.

1. Count the frequency of every character in `magazine`.
2. Traverse `ransomNote`.
3. If a character is unavailable (frequency becomes `0`), return `false`.
4. Otherwise, decrease its frequency.
5. If all characters are matched, return `true`.

---

## Algorithm

1. Create an integer array of size `26`.
2. Store the frequency of every character in `magazine`.
3. Traverse `ransomNote`.
4. Convert each character to an array index using:
   ```java
   ch - 'a'
   ```
5. If frequency is `0`, return `false`.
6. Otherwise decrement the frequency.
7. Return `true`.

---

## Java Solution

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            if (freq[ch - 'a'] == 0) {
                return false;
            }

            freq[ch - 'a']--;
        }

        return true;
    }
}
```

---

## Dry Run

### Input

```
ransomNote = "aa"
magazine = "aab"
```

Frequency array after processing `magazine`:

```
a → 2
b → 1
```

Processing `ransomNote`:

```
Need 'a'
Frequency = 2 → 1

Need 'a'
Frequency = 1 → 0
```

All characters found.

Return:

```
true
```

---

## Example 1

Input

```
ransomNote = "a"
magazine = "b"
```

Output

```
false
```

---

## Example 2

Input

```
ransomNote = "aa"
magazine = "ab"
```

Output

```
false
```

---

## Example 3

Input

```
ransomNote = "aa"
magazine = "aab"
```

Output

```
true
```

---

## Time Complexity

```
O(n + m)
```

- `n` = length of `magazine`
- `m` = length of `ransomNote`

---

## Space Complexity

```
O(1)
```

The frequency array always has **26 elements**, so the extra space is constant.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `length()` | Get string length |
| `charAt()` | Access a character |

---

## Concepts Learned

- Frequency Array
- Character Counting
- ASCII Character Mapping
- Greedy Character Usage

---

## Key Insight

Instead of using a `HashMap`, use an array because there are only **26 lowercase English letters**.

Character to index mapping:

```
'a' -> 0
'b' -> 1
'c' -> 2
...
'z' -> 25
```

Using:

```java
index = ch - 'a';
```

---

## Common Mistakes

- Using `char[]` instead of `int[]` for storing frequencies.
- Using `97` instead of `'a'` (works, but is less readable).
- Forgetting to decrement the frequency after using a character.
- Returning `true` before checking every character.

---

## Revision Status

🟢 Solved Independently

**Reason:**
- Correctly switched from `HashMap` to a frequency array.
- Implemented the optimal `O(n + m)` solution.
- Understood character-to-index mapping using `ch - 'a'`.
