# LeetCode #594 - Longest Harmonious Subsequence

## Difficulty
Easy

## Pattern
HashMap | Frequency Counting

---

## Problem

A harmonious subsequence is a subsequence where:

```
maximum value - minimum value = 1
```

Return the length of the longest harmonious subsequence.

---

## Example

### Input

```text
nums = [1,3,2,2,5,2,3,7]
```

### Frequency Map

```text
1 → 1
2 → 3
3 → 2
5 → 1
7 → 1
```

Check each key:

```text
1 + 2 → 1 + 3 = 4

2 + 3 → 3 + 2 = 5

3 + 4 → doesn't exist

5 + 6 → doesn't exist

7 + 8 → doesn't exist
```

Answer:

```text
5
```

---

## Approach

### Step 1

Count the frequency of every number.

```
number → frequency
```

using a HashMap.

---

### Step 2

For every key in the HashMap:

- Check whether `key + 1` exists.
- If it exists:

```
length = frequency(key) + frequency(key + 1)
```

Keep track of the maximum length.

---

## Methods Used

### `put()`

```java
map.put(num, map.getOrDefault(num, 0) + 1);
```

Stores or updates the frequency.

---

### `getOrDefault()`

Returns `0` if the key is not present.

---

### `keySet()`

Returns all keys in the HashMap.

```java
for (int key : map.keySet())
```

---

### `containsKey()`

Checks whether `key + 1` exists.

```java
map.containsKey(key + 1)
```

---

### `get()`

Returns the frequency of a key.

```java
map.get(key)
```

---

### `Math.max()`

Updates the largest harmonious subsequence length.

```java
maxCount = Math.max(maxCount, count);
```

---

## Complexity

**Time:** O(n)

**Space:** O(n)

---

## What I Learned

- How to iterate over a HashMap using `keySet()`.
- Difference between iterating over an array and iterating over a HashMap.
- Frequency counting using a HashMap.
- Using `containsKey()` before calling `get()`.
- Combining frequencies of consecutive keys.

---

## Revision Status

🟡 Solve Again

Reason:
I understood the approach but needed hints about iterating through the HashMap and implementing the solution independently.
