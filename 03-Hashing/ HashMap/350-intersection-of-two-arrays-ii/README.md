# LeetCode #350 — Intersection of Two Arrays II

## 🧩 Problem

Given two integer arrays `nums1` and `nums2`, return their intersection.

Each element in the result should appear as many times as it appears in **both arrays**.

The order of the result does not matter.

### Example 1

```text id="j8w7l0"
Input:
nums1 = [1,2,2,1]
nums2 = [2,2]

Output:
[2,2]
```

`2` appears twice in both arrays, so it appears twice in the result.

### Example 2

```text id="5k0l6v"
Input:
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]

Output:
[4,9]
```

The order can be different.

---

## 💡 Approach — HashMap Frequency Counting

The key idea is:

```text id="c4h0x1"
number → frequency
```

First, count how many times every number occurs in `nums1`.

For:

```text id="0o8m7r"
nums1 = [1,2,2,1]
```

the HashMap becomes:

```text id="r8i9u2"
1 → 2
2 → 2
```

Then we iterate through `nums2`.

Whenever a number:

1. Exists in the HashMap
2. Has a frequency greater than `0`

we add it to the result.

After using the number, decrease its frequency by `1`.

---

## 🔄 Example Walkthrough

```text id="m4c9n2"
nums1 = [1,2,2,1]
nums2 = [2,2]
```

Initial frequency map:

```text id="1x9q4k"
1 → 2
2 → 2
```

First `2`:

```text id="3c8f7j"
2 → 2
```

Add `2` to result and decrease:

```text id="h7y2k5"
2 → 1
```

Second `2`:

```text id="x5p1m9"
2 → 1
```

Add `2` and decrease:

```text id="k6r3v8"
2 → 0
```

Final result:

```text id="4p7s2d"
[2,2]
```

---

## 🔑 Methods Used

### `getOrDefault()`

Used for frequency counting.

```java id="r0v5s2"
map.getOrDefault(nums1[i], 0) + 1
```

If the key doesn't exist:

```text id="y7c2m1"
getOrDefault() → 0
```

If it exists, it returns its current frequency.

---

### `containsKey()`

Checks whether a number exists in the HashMap.

```java id="v2m8k4"
map.containsKey(nums2[i])
```

---

### `get()`

Gets the frequency associated with a number.

```java id="x9h3q6"
map.get(nums2[i])
```

---

### `put()`

Updates the frequency.

```java id="a3k7m0"
map.put(nums2[i], map.get(nums2[i]) - 1);
```

---

### `List.add()`

Adds a matching number to the result.

```java id="n8q2s5"
result.add(nums2[i]);
```

---

### `List.get()`

Gets an element from the List using its index.

```java id="p4x6v1"
result.get(i)
```

---

## 🧠 Important HashMap Pattern

This problem reinforces:

```text id="e7b1c9"
Need frequency?
      ↓
HashMap<Number, Integer>
```

More specifically:

```text id="q2f8a4"
number → count
```

Then we can consume the count:

```text id="j3m6x9"
count > 0
    ↓
use number
    ↓
count--
```

---

## 🔥 Difference From LeetCode #349

### #349 — Intersection of Two Arrays

Duplicates don't matter.

Example:

```text id="w6p1z4"
[1,2,2,1]
```

Result contains:

```text id="n4c7y2"
[1,2]
```

So a `HashSet` is enough.

### #350 — Intersection of Two Arrays II

Duplicates matter.

Example:

```text id="u9r2k5"
[1,2,2,1]
```

If `nums2` also has two `2`s:

```text id="b5x8m3"
[2,2]
```

So we need frequencies.

Therefore:

```text id="q8v4n1"
#349 → HashSet
#350 → HashMap
```

---

## ⏱️ Complexity

### Time Complexity

```text id="m3q7x0"
O(n + m)
```

We iterate through both arrays.

### Space Complexity

```text id="k6v2p9"
O(n)
```

The HashMap stores the distinct elements from `nums1`.

---

## 📌 LeetCode

**Problem:** #350 — Intersection of Two Arrays II

**Difficulty:** Easy

**Pattern:** HashMap / Frequency Counting

**Status:** 🟢 Independent Solve → 🔁 Revision Later
