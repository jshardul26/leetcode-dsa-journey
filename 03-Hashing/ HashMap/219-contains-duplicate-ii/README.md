# LeetCode #219 — Contains Duplicate II

## 🧩 Problem

Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` such that:

```text
nums[i] == nums[j]
```

and:

```text
|i - j| <= k
```

Otherwise, return `false`.

---

## Example 1

```text
Input:
nums = [1,2,3,1]
k = 3

Output:
true
```

The value `1` appears at indices `0` and `3`.

```text
3 - 0 = 3
```

Since:

```text
3 <= k
```

the answer is `true`.

---

## Example 2

```text
Input:
nums = [1,2,3,1,2,3]
k = 2

Output:
false
```

The duplicate values are more than `2` positions apart.

---

## 💡 Approach — HashMap

Instead of storing only whether a number exists, we store the **most recent index** where each number appeared.

The HashMap looks like:

```text
number → latest index
```

For example:

```text
nums = [1,2,3,1]
```

The map develops like this:

```text
1 → 0
2 → 1
3 → 2
```

When we encounter `1` again:

```text
current index = 3
previous index = 0
```

Calculate:

```text
3 - 0 = 3
```

If:

```text
3 <= k
```

return `true`.

---

## 🔑 Methods Used

### `containsKey()`

Checks whether a number already exists in the HashMap.

```java
map.containsKey(nums[j]);
```

### `get()`

Gets the value associated with a key.

Here, the value is the previous index.

```java
int i = map.get(nums[j]);
```

### `put()`

Stores or updates the latest index.

```java
map.put(nums[j], j);
```

---

## 🧠 Important Pattern

This problem teaches an important HashMap pattern:

```text
Need to remember the last position of something?
              ↓
HashMap
              ↓
value → index
```

Compare this with other HashMap patterns:

```text
character → frequency
word      → character
number    → index
```

The key/value relationship depends on what information the problem requires.

---

## 🔄 Important Observation

We don't need to store every index.

We only need the **most recent index**.

Why?

Suppose the same number appeared at:

```text
index 2
index 5
index 8
```

When we're at index `8`, the most recent occurrence (`5`) gives us the smallest possible distance.

Therefore, keeping the latest index is sufficient.

---

## 🚀 Alternative — HashSet + Sliding Window

There is another important solution using:

```text
HashSet + Sliding Window
```

The idea is to keep only the elements that are currently within distance `k`.

Conceptually:

```text
left ---------------- right
       window
```

When the window becomes too large, remove the element at `left`.

This approach is important because it introduces the **Sliding Window pattern**, which will be studied more deeply later.

We are keeping this technique for revision when we start Sliding Window.

---

## ⏱️ Complexity

### Time Complexity

```text
O(n)
```

We traverse the array once.

HashMap operations such as `containsKey()`, `get()`, and `put()` are `O(1)` on average.

### Space Complexity

```text
O(n)
```

In the worst case, the HashMap can contain `n` different values.

---

## 📌 LeetCode

**Problem:** #219 — Contains Duplicate II

**Difficulty:** Easy

**Primary Pattern:** HashMap

**Related Pattern:** Sliding Window + HashSet

**Status:** 🟢 Core Approach Understood → 🔁 Revision Later

