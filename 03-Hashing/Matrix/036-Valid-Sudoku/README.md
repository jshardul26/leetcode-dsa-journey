# 36. Valid Sudoku

## 🔗 Problem Link
https://leetcode.com/problems/valid-sudoku/

## 📌 Difficulty
Medium

## 🏷️ Topics
- Array
- HashSet
- Matrix

---

## 📝 Problem Statement

Determine if a `9 x 9` Sudoku board is valid.

Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits `1-9` without repetition.
2. Each column must contain the digits `1-9` without repetition.
3. Each of the nine `3 x 3` sub-boxes must contain the digits `1-9` without repetition.

Note:

- A Sudoku board could be valid but not necessarily solvable.
- Only the filled cells need to be validated.

---

## 💡 Intuition

We need to ensure that no digit appears more than once in:

- A row
- A column
- A 3×3 box

HashSet is perfect for detecting duplicates.

---

## 🚀 Approach

### Step 1

Traverse every cell of the board.

### Step 2

Skip empty cells (`'.'`).

### Step 3

For every number, create three unique identifiers:

- Row identifier
- Column identifier
- Box identifier

Example:

For number `5` at `(1,4)`:

```
Row1-5
Col4-5
Box0-1-5
```

where

```
boxRow = row / 3
boxCol = col / 3
```

### Step 4

Store these identifiers in one HashSet.

If any identifier already exists, the board is invalid.

Otherwise continue.

---

## ✅ Time Complexity

```
O(81)
```

Since Sudoku board size is fixed.

---

## ✅ Space Complexity

```
O(81)
```

Maximum identifiers stored.

---

## 📚 Key Learning

- Using HashSet to detect duplicates
- Encoding multiple constraints into strings
- Matrix traversal
- Integer division for identifying sub-boxes

---

## 🧠 Pattern

- Matrix Traversal
- HashSet
- Duplicate Detection

---

## ⭐ Java

See `Solution.java`
