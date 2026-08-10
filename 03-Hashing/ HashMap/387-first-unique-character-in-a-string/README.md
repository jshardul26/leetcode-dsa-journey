# LeetCode #387 — First Unique Character in a String

## 🧩 Problem

Given a string `s`, find the **first character that appears only once** in the string.

Return its index.

If there is no unique character, return `-1`.

### Example

```text
Input:  s = "leetcode"
Output: 0
```

Explanation:

```text
l → 1
e → 3
t → 1
c → 1
o → 1
d → 1
```

The first character that appears only once is `l`, which is at index `0`.

---

## 💡 Approach

We use a **HashMap** to store the frequency of every character.

### Step 1 — Count characters

Go through the string and store:

```text
character → frequency
```

For:

```text
"leetcode"
```

the map will contain:

```text
l → 1
e → 3
t → 1
c → 1
o → 1
d → 1
```

### Step 2 — Find the first unique character

Go through the string again from left to right.

For every character, check:

```java
map.get(ch) == 1
```

The first character satisfying this condition is the answer.

If no character has frequency `1`, return `-1`.

---

## 🧠 Why do we use two loops?

During the first loop, we are only counting.

For example:

```text
"loveleetcode"
```

When we first see `l`, we don't know whether another `l` appears later.

So we first build the complete frequency map.

Then the second loop allows us to find the **first** character whose frequency is `1`.

This gives us an important pattern:

```text
First loop
    ↓
Count frequencies

Second loop
    ↓
Use frequencies to find the answer
```

---

## ⏱️ Complexity

### Time Complexity

```text
O(n)
```

We go through the string twice:

```text
O(n) + O(n) = O(n)
```

### Space Complexity

```text
O(k)
```

where `k` is the number of distinct characters.

---

## 🔑 Key Takeaways

* Use `HashMap` for frequency counting.
* `getOrDefault()` makes frequency counting easier.
* Sometimes we need **two passes** over the input.
* The first pass gathers information.
* The second pass uses that information to find the answer.
* `map.get(ch) == 1` means the character occurs exactly once.

### Pattern Learned

**HashMap → Frequency Counting → Two Passes**

---

## 📌 LeetCode

**Problem:** #387 — First Unique Character in a String

**Difficulty:** Easy

**Pattern:** HashMap / Frequency Counting

