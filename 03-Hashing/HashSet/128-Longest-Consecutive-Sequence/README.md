# 128. Longest Consecutive Sequence

## 🔗 Problem Link
https://leetcode.com/problems/longest-consecutive-sequence/

## 📌 Difficulty
Hard

## 🏷️ Topics
- Array
- HashSet

---

## 📝 Problem Statement

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in **O(n)** time.

### Example 1

Input:
```
nums = [100,4,200,1,3,2]
```

Output:
```
4
```

Explanation:

The longest consecutive sequence is:

```
1 → 2 → 3 → 4
```

Length = **4**

---

### Example 2

Input:
```
nums = [0,3,7,2,5,8,4,6,0,1]
```

Output:
```
9
```

---

## 💡 Intuition

Sorting the array would make finding consecutive numbers easy, but sorting takes **O(n log n)**.

The problem requires an **O(n)** solution.

A HashSet allows us to check whether a number exists in **O(1)** average time.

Instead of starting from every number, only start counting from numbers that **do not have a predecessor** (`num - 1`).

---

## 🚀 Approach

### Step 1

Insert every element into a HashSet.

### Step 2

Traverse every unique number.

### Step 3

If `(num - 1)` exists, skip it because this number is not the beginning of a sequence.

### Step 4

Otherwise, keep checking:

```
num + 1
num + 2
num + 3
...
```

until the sequence ends.

### Step 5

Update the maximum sequence length.

---

## ✅ Time Complexity

Building HashSet:

```
O(n)
```

Traversing:

```
O(n)
```

Overall:

```
O(n)
```

---

## ✅ Space Complexity

```
O(n)
```

For storing all unique numbers in the HashSet.

---

## 📚 Key Learning

- HashSet provides O(1) average lookup.
- Start only from the beginning of a sequence.
- Avoid unnecessary repeated counting.
- This is a classic HashSet optimization problem.

---

## 🧠 Pattern

- HashSet
- Sequence Detection
- Array

---

## ⭐ Java

See `Solution.java`
