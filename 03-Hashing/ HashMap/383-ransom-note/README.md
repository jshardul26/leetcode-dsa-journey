# LeetCode #383 — Ransom Note

## 🧩 Problem

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed using the letters from `magazine`.

Each letter in `magazine` can only be used once.

### Example 1

```text
Input:
ransomNote = "a"
magazine = "b"

Output:
false
```

There is no `a` available in the magazine.

### Example 2

```text
Input:
ransomNote = "aa"
magazine = "aab"

Output:
true
```

There are two `a` characters available.

### Example 3

```text
Input:
ransomNote = "aa"
magazine = "ab"

Output:
false
```

Only one `a` is available, but two are required.

---

## 💡 Approach — HashMap Frequency Counting

We first count how many times each character appears in `magazine`.

For:

```text
magazine = "aab"
```

the HashMap becomes:

```text
a → 2
b → 1
```

Then we iterate through `ransomNote`.

For every character:

1. Check whether the character exists.
2. Check whether its frequency is greater than `0`.
3. Use the character.
4. Decrease its frequency.

---

## 🔄 Example Walkthrough

```text
ransomNote = "aa"
magazine = "aab"
```

Initial map:

```text
a → 2
b → 1
```

First `a`:

```text
a → 2
```

Use it:

```text
a → 1
```

Second `a`:

```text
a → 1
```

Use it:

```text
a → 0
```

All required characters were available.

Therefore:

```text
true
```

---

## 🔑 Methods Used

### `charAt()`

Gets a character from a String.

```java
char ch = magazine.charAt(i);
```

### `getOrDefault()`

Used for frequency counting.

```java
map.getOrDefault(ch, 0)
```

If the character doesn't exist, it returns `0`.

### `containsKey()`

Checks whether a character exists in the HashMap.

```java
map.containsKey(ch)
```

### `get()`

Gets the current frequency.

```java
map.get(ch)
```

### `put()`

Adds or updates a key-value pair.

```java
map.put(ch, map.get(ch) - 1);
```

---

## 🧠 Important Pattern

This is another **frequency counting** problem.

The general pattern is:

```text
Thing → Frequency
```

For this problem:

```text
Character → Frequency
```

For example:

```text
a → 2
b → 1
```

Then consume the available frequency:

```text
frequency > 0
      ↓
    use it
      ↓
 frequency--
```

---

## 🔥 Connection With Previous Problems

### #350 — Intersection of Two Arrays II

```text
number → frequency
```

### #383 — Ransom Note

```text
character → frequency
```

The underlying HashMap pattern is the same.

Only the type of key changes:

```text
Integer → Integer
Character → Integer
```

This is an important HashMap pattern to recognize.

---

## ⏱️ Complexity

### Time Complexity

```text
O(n + m)
```

Where:

* `n` = length of `magazine`
* `m` = length of `ransomNote`

### Space Complexity

```text
O(k)
```

where `k` is the number of distinct characters.

For lowercase English letters, `k` is at most `26`.

---

## 📌 LeetCode

**Problem:** #383 — Ransom Note

**Difficulty:** Easy

**Pattern:** HashMap / Frequency Counting

**Status:** 🟢 Independent Attempt → 🔁 Revision Later
