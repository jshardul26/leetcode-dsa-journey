# LeetCode #771 — Jewels and Stones

## 🧩 Problem

You are given two strings:

* `jewels` — characters representing types of jewels.
* `stones` — characters representing the stones you have.

Return the number of stones that are also jewels.

Each character in `stones` represents one stone.

---

## Example 1

```text id="4o7g2n"
Input:
jewels = "aA"
stones = "aAAbbbb"

Output:
3
```

The jewel characters are:

```text id="w8f2x1"
a
A
```

The stones containing jewel characters are:

```text id="0h4v9q"
a
A
A
```

Therefore:

```text id="z6j3p8"
3
```

---

## Example 2

```text id="q2m7v5"
Input:
jewels = "z"
stones = "ZZ"

Output:
0
```

`z` and `Z` are different characters.

---

## 💡 Approach — HashSet

We only need to answer one question for every stone:

```text id="6v3p9m"
Is this character a jewel?
```

We don't need to know how many times each jewel appears.

Therefore, a `HashSet` is ideal.

### Step 1

Store every character from `jewels` in a HashSet.

```text id="k4x1s7"
jewels = "aA"

Set = {a, A}
```

### Step 2

Iterate through `stones`.

For every character:

```text id="r9m2c6"
if set.contains(character)
        ↓
      true
        ↓
     count++
```

---

## 🔄 Walkthrough

Given:

```text id="7n5q2a"
jewels = "aA"
stones = "aAAbbbb"
```

HashSet:

```text id="3w8k1p"
{a, A}
```

Now check each stone:

```text id="x6f4z9"
a → jewel → count = 1
A → jewel → count = 2
A → jewel → count = 3
b → not a jewel
b → not a jewel
b → not a jewel
b → not a jewel
```

Final answer:

```text id="s2v7m4"
3
```

---

## 🔑 Methods Used

### `charAt()`

Gets a character at a particular index.

```java id="h8r3y5"
char ch = jewels.charAt(i);
```

---

### `add()`

Adds a character to the HashSet.

```java id="m4p9q2"
set.add(ch);
```

---

### `contains()`

Checks whether a character exists in the HashSet.

```java id="c7x1n6"
set.contains(ch);
```

This is the most important method in this problem.

---

## 🧠 Why HashSet Instead of HashMap?

We could use a HashMap, but it would be unnecessary.

We don't need:

```text id="v3k8s1"
character → frequency
```

We only need:

```text id="b9m2x5"
character exists?
```

Therefore:

```text id="q4r7n0"
HashSet
   ↓
contains()
```

is the correct data structure.

---

## 🔥 Pattern

This problem reinforces the **membership checking** pattern:

```text id="t5c2y8"
Given a collection of values
        ↓
Need to quickly check whether something exists
        ↓
HashSet
```

Examples:

```text id="p8v3k1"
HashSet.contains(value)
```

gives approximately `O(1)` average lookup time.

---

## ⏱️ Complexity

### Time Complexity

```text id="n4x7q2"
O(j + s)
```

Where:

* `j` = length of `jewels`
* `s` = length of `stones`

### Space Complexity

```text id="k1m6p9"
O(j)
```

The HashSet stores the distinct jewel characters.

---

## 📌 LeetCode

**Problem:** #771 — Jewels and Stones

**Difficulty:** Easy

**Pattern:** HashSet / Membership Checking

**Status:** 🟢 Solved Independently → 🔁 Revision Later
