# LeetCode #599 — Minimum Index Sum of Two Lists

## 🧩 Problem

Given two arrays of strings `list1` and `list2`, find the common strings with the smallest index sum.

For a common string:

```text
index sum = index in list1 + index in list2
```

Return all common strings having the minimum index sum.

The answer can be returned in any order.

---

## Example 1

```text
Input:
list1 = ["Shogun","Tapioca Express","Burger King","KFC"]

list2 = ["Piatti","The Grill at Torrey Pines",
         "Hungry Hunter Steakhouse","Shogun"]

Output:
["Shogun"]
```

`Shogun` has index:

```text
list1 → 0
list2 → 3

index sum = 0 + 3 = 3
```

---

## Example 2

```text
Input:
list1 = ["Shogun","Tapioca Express","Burger King","KFC"]

list2 = ["KFC","Shogun","Burger King"]

Output:
["Shogun"]
```

Index sums:

```text
Shogun      → 0 + 1 = 1
Burger King → 2 + 2 = 4
KFC         → 3 + 0 = 3
```

The minimum is `1`.

Therefore:

```text
["Shogun"]
```

---

## 💡 Approach

Use a HashMap to store the index of every string in `list1`.

```text
String → index
```

For example:

```text
list1 = ["Shogun","Tapioca Express","Burger King","KFC"]
```

HashMap:

```text
Shogun          → 0
Tapioca Express → 1
Burger King     → 2
KFC             → 3
```

Then iterate through `list2`.

The current loop variable `i` is already the index of the restaurant in `list2`.

If the restaurant exists in the HashMap:

```text
index sum = map.get(restaurant) + i
```

Compare this sum with the current minimum.

---

## 🔄 Important Logic

### New minimum

If:

```java
sum < minSum
```

we found a better answer.

Therefore:

```java
minSum = sum;
result.clear();
result.add(restaurant);
```

We clear the previous results because they had a larger index sum.

---

### Same minimum

If:

```java
sum == minSum
```

another restaurant has the same minimum index sum.

Therefore:

```java
result.add(restaurant);
```

We keep both answers.

---

## 🧠 Key Insight

We only need **one HashMap**.

Initially, it might seem necessary to create:

```text
HashMap 1 → list1 indexes
HashMap 2 → list2 indexes
HashMap 3 → index sums
```

But this is unnecessary.

While iterating through `list2`:

```text
i = current index in list2
```

And:

```text
map.get(restaurant) = index in list1
```

Therefore we can immediately calculate:

```text
index sum = map.get(restaurant) + i
```

No second or third HashMap is required.

---

## 🔑 Methods Used

### `put()`

Stores the restaurant and its index.

```java
map.put(list1[i], i);
```

### `containsKey()`

Checks whether a restaurant exists in both lists.

```java
map.containsKey(restaurant);
```

### `get()`

Gets the index stored for the restaurant.

```java
map.get(restaurant);
```

### `clear()`

Removes previous results when a smaller index sum is found.

```java
result.clear();
```

### `add()`

Adds a restaurant to the result.

```java
result.add(restaurant);
```

### `toArray()`

Converts `List<String>` into `String[]`.

```java
result.toArray(new String[0]);
```

---

## ⏱️ Complexity

### Time Complexity

```text
O(n + m)
```

Where:

* `n` = length of `list1`
* `m` = length of `list2`

### Space Complexity

```text
O(n)
```

The HashMap stores the restaurants from `list1`.

---

## 🧠 Pattern

This problem teaches a different use of HashMap.

Previously:

```text
number → frequency
```

Now:

```text
String → index
```

The general HashMap idea is:

```text
Store information about something
        ↓
Use that information later
        ↓
Avoid repeatedly searching
```

---

## 📌 LeetCode

**Problem:** #599 — Minimum Index Sum of Two Lists

**Difficulty:** Easy

**Pattern:** HashMap / Index Tracking

**Status:** 🟡 Understood Conceptually → 🔁 Solve Again

### Revision Note

I understood the HashMap approach, but I could not independently code the solution.

When revising, first try to code it from scratch without looking at the solution.
