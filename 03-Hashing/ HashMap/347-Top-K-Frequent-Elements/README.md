# 347. Top K Frequent Elements

## 🔗 Problem Link
https://leetcode.com/problems/top-k-frequent-elements/

## 📌 Difficulty
Medium

## 🏷️ Topics
- Array
- HashMap
- Heap (Priority Queue)
- Bucket Sort

---

## 📝 Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

You may return the answer in any order.

### Example 1

Input:
```
nums = [1,1,1,2,2,3], k = 2
```

Output:
```
[1,2]
```

### Example 2

Input:
```
nums = [1], k = 1
```

Output:
```
[1]
```

---

## 💡 Intuition

The first step is to count how many times each number appears.

After finding the frequency of every element, we need to identify the `k` elements with the highest frequencies.

A HashMap efficiently stores frequencies, while a Min Heap keeps track of the top `k` frequent elements.

---

## 🚀 Approach

### Step 1
Create a HashMap to count the frequency of every number.

### Step 2
Create a Min Heap ordered by frequency.

### Step 3
Insert every unique number into the heap.

If heap size becomes greater than `k`, remove the smallest frequency element.

### Step 4
The heap now contains the `k` most frequent elements.

Extract them into an array.

---

## ✅ Time Complexity

- Frequency Map: **O(n)**
- Heap Operations: **O(n log k)**

Overall:

```
O(n log k)
```

---

## ✅ Space Complexity

HashMap + Heap

```
O(n)
```

---

## 📚 Key Learning

- Frequency counting using HashMap
- Using PriorityQueue as a Min Heap
- Keeping heap size fixed to `k`
- Heap is useful when only top `k` elements are required

---

## 🧠 Pattern

- HashMap
- Heap (Priority Queue)
- Top K Elements Pattern

---

## ⭐ Java
See `Solution.java`
