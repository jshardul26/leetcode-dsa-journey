# LeetCode #409 - Longest Palindrome

## Difficulty

Easy

## Pattern

HashMap | Frequency Counting

---

## Problem

Given a string `s`, return the length of the longest palindrome that can be built using its characters.

You don't have to use every character.

---

## Example

### Input

```text
s = "abccccdd"
```

### Frequency Map

```text
a → 1
b → 1
c → 4
d → 2
```

### Characters Used

```text
a → 0
b → 0
c → 4
d → 2
```

Current length:

```text
6
```

Since at least one character has an odd frequency, one of them can be placed in the center.

Final answer:

```text
7
```

---

## Key Observation

A palindrome consists of:

```
left half + center + right half
```

### Even Frequency

If a character appears an even number of times, use all of them.

Example:

```text
4 → use 4
6 → use 6
```

---

### Odd Frequency

If a character appears an odd number of times:

```text
3 → use 2
5 → use 4
7 → use 6
```

Save one character for the center.

Only **one** odd character can occupy the center.

---

## Approach

### Step 1

Count the frequency of every character.

```text
character → frequency
```

using a HashMap.

---

### Step 2

Iterate through every frequency.

- If frequency is even:
  - Add the entire frequency.
- If frequency is odd:
  - Add `frequency - 1`.
  - Remember that an odd frequency exists.

---

### Step 3

If at least one odd frequency exists:

```text
answer++
```

because one odd character can be placed in the middle.

---

## Methods Used

### `put()`

```java
map.put(ch, map.getOrDefault(ch, 0) + 1);
```

Stores or updates the frequency.

---

### `getOrDefault()`

Returns the stored value if the key exists, otherwise returns `0`.

---

### `keySet()`

Iterates through all characters stored in the HashMap.

```java
for (char key : map.keySet())
```

---

### `get()`

Returns the frequency of a character.

```java
map.get(key)
```

---

## Complexity

### Time Complexity

```text
O(n)
```

- Building the frequency map: **O(n)**
- Iterating through the HashMap: **O(k)**

Overall:

```text
O(n)
```

---

### Space Complexity

```text
O(k)
```

`k` = number of distinct characters.

---

## What I Learned

- Frequency counting using a HashMap.
- Iterating over a HashMap using `keySet()`.
- Building a palindrome from character frequencies.
- Difference between even and odd frequencies.
- Using a boolean flag to handle one center character.

---

## Pattern Recognition

Ask yourself:

> **Do I need to know how many times each element appears?**

If yes:

```text
HashMap<Character, Integer>
```

Then ask:

> **What does the frequency tell me?**

In this problem:

- Even frequency → use all.
- Odd frequency → use all except one.
- One odd character can be used in the center.

---

## Status

🟢 Solved Independently

**Revision:** Normal Revision Queue
