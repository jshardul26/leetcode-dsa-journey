# LeetCode #136 — Single Number

## 🧩 Problem

Given a non-empty array of integers `nums`, every element appears twice except for one element.

Find and return the element that appears only once.

### Example

```text
Input:  nums = [2, 2, 1]
Output: 1
```

Another example:

```text
Input:  nums = [4, 1, 2, 1, 2]
Output: 4
```

---

## 💡 Approach — HashSet

We use a `HashSet` to keep track of numbers that have appeared an odd number of times so far.

For every number:

* If the number is **not** in the Set → add it.
* If the number is **already** in the Set → remove it.

Because every duplicate appears exactly twice, the two occurrences cancel each other.

### Example

```text
nums = [4, 1, 2, 1, 2]
```

Step by step:

```text
4 → add     → {4}
1 → add     → {4, 1}
2 → add     → {4, 1, 2}
1 → remove  → {4, 2}
2 → remove  → {4}
```

At the end:

```text
{4}
```

The only remaining element is the answer.

---

## 🔑 HashSet Methods Used

### `contains()`

Checks whether an element already exists.

```java
set.contains(nums[i])
```

Returns:

```text
true  → element exists
false → element doesn't exist
```

### `add()`

Adds an element to the Set.

```java
set.add(nums[i]);
```

### `remove()`

Removes an element from the Set.

```java
set.remove(nums[i]);
```

### `iterator().next()`

A `HashSet` does not use indexes like an array.

```java
set.iterator().next()
```

gets an element from the Set.

In this problem, only one element remains, so that element is the answer.

---

## 🧠 Important Pattern

```text
Need to know whether an element exists?
            ↓
         HashSet
```

For this problem:

```text
Already exists → remove
Doesn't exist  → add
```

---

## ⏱️ Complexity

### Time Complexity

```text
O(n)
```

We iterate through the array once.

### Space Complexity

```text
O(n)
```

In the worst case, the Set can contain approximately `n / 2` unique elements.

---

## 🚀 Optimal Approach — XOR

There is an even better solution using the **XOR (`^`) operator**.

Important XOR properties:

```text
a ^ a = 0
a ^ 0 = a
```

Therefore:

```text
4 ^ 1 ^ 2 ^ 1 ^ 2
```

becomes:

```text
4 ^ (1 ^ 1) ^ (2 ^ 2)
```

which becomes:

```text
4 ^ 0 ^ 0
```

and finally:

```text
4
```

The XOR solution uses:

```text
Time:  O(n)
Space: O(1)
```

We will learn XOR in more detail later.

---

## 📌 LeetCode

**Problem:** #136 — Single Number

**Difficulty:** Easy

**Primary Pattern:** HashSet

**Secondary Pattern:** Bit Manipulation / XOR.

