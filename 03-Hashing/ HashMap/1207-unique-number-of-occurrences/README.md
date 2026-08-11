# LeetCode #1207 — Unique Number of Occurrences

## 🧩 Problem

Given an integer array `arr`, return `true` if the number of occurrences of each value in the array is unique.

Otherwise, return `false`.

---

## Example 1

```text
Input:
arr = [1,2,2,1,1,3]

Output:
true
```

Frequencies:

```text
1 → 3
2 → 2
3 → 1
```

The frequencies are:

```text
3, 2, 1
```

All frequencies are unique, so the answer is `true`.

---

## Example 2

```text
Input:
arr = [1,2]

Output:
false
```

Frequencies:

```text
1 → 1
2 → 1
```

Both values occur once.

The frequency `1` appears twice, so the answer is `false`.

---

## 💡 Approach

This problem uses **two data structures**:

```text
HashMap + HashSet
```

### Step 1 — Count frequencies

Use a HashMap:

```text
number → frequency
```

For:

```text
[1,2,2,1,1,3]
```

we get:

```text
1 → 3
2 → 2
3 → 1
```

---

### Step 2 — Check whether frequencies are unique

We no longer care about the numbers themselves.

We only care about their frequencies:

```text
3
2
1
```

Store these frequencies in a HashSet.

Because a HashSet only stores unique values, we can detect a duplicate frequency.

---

## 🔄 Walkthrough

Initial HashMap:

```text
1 → 3
2 → 2
3 → 1
```

Start with an empty Set:

```text
{}
```

Check frequency `3`:

```text
3 already exists? No

Set = {3}
```

Check frequency `2`:

```text
2 already exists? No

Set = {3,2}
```

Check frequency `1`:

```text
1 already exists? No

Set = {3,2,1}
```

All frequencies are unique.

Return:

```text
true
```

---

## 🔑 Methods Used

### `getOrDefault()`

Used to count occurrences.

```java
map.getOrDefault(arr[i], 0) + 1
```

If the key doesn't exist, it starts with `0`.

---

### `keySet()`

Returns all keys from the HashMap.

```java
map.keySet()
```

Example:

```text
Map:
1 → 3
2 → 2
3 → 1

keySet:
{1,2,3}
```

---

### `get()`

Gets the frequency associated with a key.

```java
map.get(key)
```

---

### `contains()`

Checks whether a frequency already exists in the HashSet.

```java
set.contains(map.get(key))
```

---

### `add()`

Adds a frequency to the HashSet.

```java
set.add(map.get(key))
```

---

## 🧠 Important Pattern

This problem combines two patterns:

```text
HashMap
   ↓
count frequency
   ↓
number → frequency
   ↓
HashSet
   ↓
check whether frequencies are unique
```

### General pattern

```text
Need to count something?
        ↓
     HashMap

Need to check uniqueness?
        ↓
      HashSet
```

---

## 🔥 Connection With Previous Problems

### #350 — Intersection of Two Arrays II

Used:

```text
number → frequency
```

### #383 — Ransom Note

Used:

```text
character → frequency
```

### #1207 — Unique Number of Occurrences

Uses:

```text
number → frequency
        ↓
frequency → HashSet
```

So this problem combines ideas you've already practiced.

---

## ⏱️ Complexity

### Time Complexity

```text
O(n)
```

We traverse the array and then iterate through the distinct keys.

### Space Complexity

```text
O(n)
```

The HashMap and HashSet can both contain up to `n` elements in the worst case.

---

## 📌 LeetCode

**Problem:** #1207 — Unique Number of Occurrences

**Difficulty:** Easy

**Pattern:** HashMap + HashSet / Frequency Counting

**Status:** 🟢 Solved Independently → 🔁 Revision Later
