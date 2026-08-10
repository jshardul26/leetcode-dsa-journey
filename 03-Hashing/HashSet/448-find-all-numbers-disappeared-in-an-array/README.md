# LeetCode #448 — Find All Numbers Disappeared in an Array

## 🧩 Problem

Given an integer array `nums` of length `n` where:

```text
1 <= nums[i] <= n
```

Some numbers appear once, some appear twice, and some numbers may be missing.

Find all numbers in the range:

```text
1 → n
```

that do not appear in `nums`.

### Example

```text
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```

The numbers from `1` to `8` should be:

```text
1 2 3 4 5 6 7 8
```

The array contains:

```text
1 2 3 4 7 8
```

Therefore:

```text
5 6
```

are missing.

---

## 💡 Approach — HashSet

We use a `HashSet` to store all numbers that appear in the array.

### Step 1 — Store the numbers

For:

```text
[4,3,2,7,8,2,3,1]
```

the Set becomes:

```text
{1,2,3,4,7,8}
```

Duplicates are automatically ignored by the Set.

### Step 2 — Check numbers from 1 to n

We loop from:

```text
1 → n
```

For every number, use:

```java
set.contains(i)
```

If it returns `false`, that number is missing.

For example:

```text
1 → found
2 → found
3 → found
4 → found
5 → missing
6 → missing
7 → found
8 → found
```

Therefore the answer is:

```text
[5,6]
```

---

## 🔑 Methods Used

### `add()`

Adds an element to the HashSet.

```java
set.add(nums[i]);
```

### `contains()`

Checks whether an element exists.

```java
set.contains(i)
```

Returns:

```text
true  → element exists
false → element doesn't exist
```

---

## 🧠 Important Pattern

This problem reinforces:

```text
Need to know whether something exists?
            ↓
         HashSet
```

The general approach:

```text
Array
 ↓
HashSet
 ↓
Check expected values
 ↓
Find values that aren't present
```

---

## ⏱️ Complexity

### Time Complexity

```text
O(n)
```

We iterate through the array once and then through `1` to `n`.

### Space Complexity

```text
O(n)
```

The HashSet can contain up to `n` different values.

---

## 📌 LeetCode

**Problem:** #448 — Find All Numbers Disappeared in an Array

**Difficulty:** Easy

**Pattern:** HashSet

**Status:** Assisted Solve → Revision Later

