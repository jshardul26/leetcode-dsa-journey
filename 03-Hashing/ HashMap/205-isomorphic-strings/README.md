# LeetCode 205 — Isomorphic Strings

## Problem

Given two strings `s` and `t`, determine whether they are **isomorphic**.

Two strings are isomorphic if the characters in `s` can be replaced to get `t`.

Each character must:

* Map to exactly one character.
* Preserve the order of characters.
* Have a one-to-one mapping.
* Different characters cannot map to the same character.

---

## Example 1

### Input

```text
s = "egg"
t = "add"
```

### Mapping

```text
e → a
g → d
```

Therefore:

```text
egg
↓↓↓
add
```

### Output

```text
true
```

---

## Example 2

### Input

```text
s = "foo"
t = "bar"
```

### Mapping

```text
f → b
o → a
o → r ❌
```

The character `o` is trying to map to two different characters.

### Output

```text
false
```

---

## Example 3

### Input

```text
s = "ab"
t = "cc"
```

Mapping:

```text
a → c
b → c
```

This is invalid because two different characters are mapping to the same character.

### Output

```text
false
```

---

## Approach

We need to maintain a **one-to-one mapping** between the characters of `s` and `t`.

We use two `HashMap`s:

```text
mapST
```

Stores:

```text
s character → t character
```

And:

```text
mapTS
```

Stores:

```text
t character → s character
```

### Why two maps?

Consider:

```text
s = "ab"
t = "cc"
```

Using only `s → t`:

```text
a → c
b → c
```

The mapping appears valid.

But it violates the one-to-one requirement.

Using the reverse map:

```text
c → a
```

When we encounter `b → c`, we discover:

```text
c → a
```

but we need:

```text
c → b
```

Therefore, the strings are not isomorphic.

---

## Algorithm

1. If the lengths are different, return `false`.
2. Create two `HashMap`s.
3. Traverse both strings simultaneously.
4. Get the current characters:

   * `ch1` from `s`
   * `ch2` from `t`
5. Check the mapping `s → t`.
6. Check the mapping `t → s`.
7. If either mapping is inconsistent, return `false`.
8. Otherwise, add the new mappings.
9. If the entire string is processed successfully, return `true`.

---

## Java Code

```java
import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // Check s -> t mapping
            if (mapST.containsKey(ch1)) {

                if (mapST.get(ch1) != ch2) {
                    return false;
                }

            } else {
                mapST.put(ch1, ch2);
            }

            // Check t -> s mapping
            if (mapTS.containsKey(ch2)) {

                if (mapTS.get(ch2) != ch1) {
                    return false;
                }

            } else {
                mapTS.put(ch2, ch1);
            }
        }

        return true;
    }
}
```

---

## Dry Run

Consider:

```text
s = "paper"
t = "title"
```

| Index | `s` | `t` | Mapping |
| ----: | :-: | :-: | ------- |
|     0 |  p  |  t  | p → t   |
|     1 |  a  |  i  | a → i   |
|     2 |  p  |  t  | p → t ✓ |
|     3 |  e  |  l  | e → l   |
|     4 |  r  |  e  | r → e   |

All mappings remain consistent.

Therefore:

```text
true
```

---

## Complexity Analysis

Let `n` be the length of the strings.

### Time Complexity

```text
O(n)
```

We traverse the strings once.

HashMap operations such as `containsKey()`, `get()`, and `put()` take **O(1)** average time.

### Space Complexity

```text
O(n)
```

In the worst case, we store mappings for every character.

---

## Key Pattern

### HashMap — One-to-One Mapping

This problem teaches an important HashMap pattern:

```text
Character A
     ↓
Must always map to
     ↓
Character B
```

And the reverse must also be true:

```text
Character B
     ↓
Must always map to
     ↓
Character A
```

### Pattern to Remember

```text
One-to-one relationship
        ↓
Two HashMaps
        ↓
A → B
B → A
```

Whenever you see a problem involving **mapping one set of values to another with a one-to-one relationship**, think about this pattern.

---

## Important Java Methods

| Method             | Purpose                         |
| ------------------ | ------------------------------- |
| `containsKey(key)` | Checks whether a mapping exists |
| `get(key)`         | Gets the mapped value           |
| `put(key, value)`  | Creates a mapping               |
| `charAt(i)`        | Gets a character at an index    |

---

## Related Problems

* LeetCode 205 — Isomorphic Strings
* LeetCode 290 — Word Pattern
* LeetCode 49 — Group Anagrams
* LeetCode 242 — Valid Anagram
* LeetCode 1 — Two Sum

---

## Key Takeaway

The most important idea is:

> **For an isomorphic relationship, mapping must work in both directions.**

So remember:

```text
s → t
t → s

Two-way mapping = One-to-one mapping
```

