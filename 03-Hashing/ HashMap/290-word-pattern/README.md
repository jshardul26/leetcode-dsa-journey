# LeetCode 290 — Word Pattern

## Problem

Given a `pattern` and a string `s`, determine if `s` follows the same pattern.

A string follows a pattern if there is a **bijection** between a character in `pattern` and a non-empty word in `s`.

In other words:

* Each character must map to exactly one word.
* Each word must map to exactly one character.
* The order must remain consistent.

---

## Example 1

### Input

```text
pattern = "abba"
s = "dog cat cat dog"
```

### Output

```text
true
```

### Explanation

The mapping is:

```text
a → dog
b → cat
```

Therefore:

```text
a b b a
↓ ↓ ↓ ↓
dog cat cat dog
```

The pattern matches.

---

## Example 2

### Input

```text
pattern = "abba"
s = "dog cat cat fish"
```

### Output

```text
false
```

### Explanation

The mapping starts as:

```text
a → dog
b → cat
```

But at the last position:

```text
a → fish
```

The character `a` was already mapped to `dog`.

Therefore, the mapping is inconsistent.

---

## Example 3

### Input

```text
pattern = "aaaa"
s = "dog cat cat dog"
```

### Output

```text
false
```

### Explanation

The pattern requires every `a` to map to the same word.

But:

```text
a → dog
a → cat
```

A single character cannot map to multiple words.

---

# Approach

The key idea is **two-way mapping**.

We need to maintain:

```text
Character → Word
```

and:

```text
Word → Character
```

We use two `HashMap`s.

### Map 1

```java
HashMap<Character, String> charToWord
```

This ensures that a character always maps to the same word.

Example:

```text
a → dog
```

If later we get:

```text
a → cat
```

the pattern is invalid.

### Map 2

```java
HashMap<String, Character> wordToChar
```

This ensures that a word cannot belong to multiple pattern characters.

Example:

```text
dog → a
```

If later we get:

```text
dog → b
```

the pattern is invalid.

---

# Algorithm

1. Split the string `s` into individual words.
2. Check whether the number of words equals the length of `pattern`.
3. Create two HashMaps.
4. Traverse the pattern and words together.
5. Check the `character → word` mapping.
6. Check the `word → character` mapping.
7. If either mapping is inconsistent, return `false`.
8. Otherwise, add the mapping.
9. If the entire input is processed successfully, return `true`.

---

# Pseudocode

```text
words = split s

if pattern.length != number of words
    return false

create character → word map
create word → character map

for every character and word:

    if character already exists:
        if mapped word != current word
            return false
    else:
        store character → word

    if word already exists:
        if mapped character != current character
            return false
    else:
        store word → character

return true
```

---

# Java Solution

```java
import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        // Number of characters and words must be equal
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            // Check character -> word mapping
            if (charToWord.containsKey(ch)) {

                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }

            } else {
                charToWord.put(ch, word);
            }

            // Check word -> character mapping
            if (wordToChar.containsKey(word)) {

                if (wordToChar.get(word) != ch) {
                    return false;
                }

            } else {
                wordToChar.put(word, ch);
            }
        }

        return true;
    }
}
```

---

# Dry Run

Consider:

```text
pattern = "abba"
s = "dog cat cat dog"
```

After splitting:

```text
words = ["dog", "cat", "cat", "dog"]
```

### Index 0

```text
character = a
word = dog
```

Store:

```text
a → dog
dog → a
```

### Index 1

```text
character = b
word = cat
```

Store:

```text
b → cat
cat → b
```

### Index 2

```text
character = b
word = cat
```

Existing mappings:

```text
b → cat ✓
cat → b ✓
```

### Index 3

```text
character = a
word = dog
```

Existing mappings:

```text
a → dog ✓
dog → a ✓
```

Everything is consistent.

```text
return true
```

---

# Why Two HashMaps?

Using only one map is not enough.

Consider:

```text
pattern = "ab"
s = "dog dog"
```

With only:

```text
character → word
```

we would get:

```text
a → dog
b → dog
```

This would incorrectly appear valid.

But two different characters cannot map to the same word.

The reverse map catches this:

```text
dog → a
```

When we encounter:

```text
b → dog
```

we already know:

```text
dog → a
```

Therefore:

```text
false
```

---

# Complexity Analysis

Let `n` be the number of words.

## Time Complexity

```text
O(n)
```

We traverse the pattern and words once.

HashMap operations such as:

```java
containsKey()
get()
put()
```

take **O(1)** average time.

## Space Complexity

```text
O(n)
```

In the worst case, the HashMaps store mappings for every character and word.

---

# Key Pattern

## Two-Way / One-to-One Mapping

This problem is an important **HashMap pattern**.

Whenever you need a one-to-one relationship:

```text
A → B
B → A
```

think about using **two HashMaps**.

### Pattern

```text
       One-to-One Mapping
              ↓
        ┌─────┴─────┐
        ↓           ↓
      A → B       B → A
        ↓           ↓
     HashMap     HashMap
```

---

# Related Problems

* **205 — Isomorphic Strings**
* **290 — Word Pattern**
* **242 — Valid Anagram**
* **49 — Group Anagrams**
* **1 — Two Sum**
* **349 — Intersection of Two Arrays**
* **202 — Happy Number**

---

# Key Takeaway

The most important concept from this problem is:

```text
ONE-TO-ONE MAPPING
        ↓
TWO-WAY CHECKING
        ↓
TWO HASHMAPS
```

For Word Pattern:

```text
Character ↔ Word
```

For Isomorphic Strings:

```text
Character ↔ Character
```

The underlying pattern is the same.

