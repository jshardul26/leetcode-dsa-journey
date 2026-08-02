# Contains Duplicate

**LeetCode Problem:** #217
**Difficulty:** Easy
**Data Structure:** Array + HashSet
**Pattern:** Hashing / Frequency Detection
**Language:** Java

---

## 🧠 Problem in Simple Words

You are given an integer array.

You need to check whether any number appears more than once.

Return:

```text
true
```

if at least one duplicate exists.

Otherwise, return:

```text
false
```

### Example

```text
Input:
nums = [1, 2, 3, 1]

Output:
true
```

The number `1` appears twice.

Another example:

```text
Input:
nums = [1, 2, 3, 4]

Output:
false
```

Every number appears only once.

---

# 🐢 Brute Force Approach

The brute force approach is to compare every number with every other number.

For every index `i`, compare `nums[i]` with all elements after it.

If we find two equal values, return `true`.

If we finish checking all pairs without finding a duplicate, return `false`.

### Brute Force Pseudocode

```text
For every index i:

    For every index j after i:

        If nums[i] == nums[j]:

            Return true

Return false
```

### Brute Force Complexity

```text
Time Complexity: O(n²)
Space Complexity: O(1)
```

The problem is that we may need to compare almost every pair of elements.

---

# 🚀 Optimized Approach — HashSet

We can solve this problem in one pass using a `HashSet`.

A `HashSet` stores **unique values**.

We don't need to store the index of each number.

We only need to answer:

> "Have I seen this number before?"

Therefore, a `HashSet` is the right data structure.

---

## 💡 Key Idea

For every number in the array:

1. Check whether the number is already in the `HashSet`.
2. If it is already present, we found a duplicate.
3. Return `true`.
4. If it is not present, add it to the `HashSet`.
5. Continue checking the remaining numbers.
6. If we finish the entire array without finding a duplicate, return `false`.

The important order is:

```text
CHECK
  ↓
ADD
```

We must check before adding.

---

# 🔍 Dry Run

Consider:

```text
nums = [1, 2, 3, 1]
```

Initially:

```text
Set = {}
```

### Step 1

Current number:

```text
1
```

Check:

```text
Is 1 in Set?
```

No.

Add `1`.

```text
Set = {1}
```

---

### Step 2

Current number:

```text
2
```

Check:

```text
Is 2 in Set?
```

No.

Add `2`.

```text
Set = {1, 2}
```

---

### Step 3

Current number:

```text
3
```

Check:

```text
Is 3 in Set?
```

No.

Add `3`.

```text
Set = {1, 2, 3}
```

---

### Step 4

Current number:

```text
1
```

Check:

```text
Is 1 in Set?
```

Yes.

Therefore:

```text
return true
```

We found a duplicate.

---

# 💻 Java Implementation

```java
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }

        return false;
    }
}
```

---

# 🧠 Why HashSet Instead of HashMap?

In the previous problem, **Two Sum**, we used a `HashMap`.

There we needed:

```text
Number → Index
```

Because when we found the required number, we needed its original index.

For this problem, we don't need the index.

We only need:

```text
Have I seen this number?
```

Therefore:

```text
Two Sum:
HashMap
Number → Index

Contains Duplicate:
HashSet
Number
```

### Rule to Remember

> If you need to store a value and associate additional information with it, think `HashMap`.

> If you only need to know whether a value exists or has been seen, think `HashSet`.

---

# 🔎 Pattern Recognition

When you see a problem asking:

* Does a duplicate exist?
* Have I seen this value before?
* Is there a repeated element?
* Are all elements unique?
* Have I already processed this value?

Think:

```text
HashSet
```

The common pattern is:

```text
For each element:

    If Set contains element:
        Duplicate found

    Else:
        Add element
```

Mental trigger:

> **"Have I seen this before?" → HashSet**

---

# ⚡ Alternative Approach — Sorting

Another possible approach is to sort the array first.

Example:

```text
Before sorting:
[3, 1, 2, 3]

After sorting:
[1, 2, 3, 3]
```

Now duplicates will be adjacent.

We can check:

```text
nums[i] == nums[i - 1]
```

If they are equal, we found a duplicate.

### Complexity

```text
Time Complexity: O(n log n)
Space Complexity: Depends on sorting implementation
```

The `HashSet` approach is generally preferable when we want an expected `O(n)` solution and don't need to modify the input array.

---

# ❌ My Mistakes During First Attempt

### Mistake 1: Checked After Inserting

Initially, the logic was:

```text
ADD
↓
CHECK
```

This causes an immediate false duplicate detection.

For example:

```text
nums = [1, 2, 3]
```

First element:

```text
Add 1
```

Then:

```text
Check if 1 exists
```

Of course it exists because we just added it.

Correct order:

```text
CHECK
↓
If not present
↓
ADD
```

---

### Mistake 2: Initially Used HashMap

The first attempt used:

```java
HashMap<Integer, Integer>
```

But the problem does not require storing the index.

The better data structure is:

```java
HashSet<Integer>
```

because we only need to track whether a number has already appeared.

---

### Mistake 3: Initially Used `map.contains()`

For a `HashMap`, the correct method for checking a key is:

```java
map.containsKey(key)
```

For a `HashSet`, the correct method is:

```java
set.contains(value)
```

---

# 🧠 What I Learned

The most important lesson from this problem is:

> Choose the data structure based on the information the problem requires.

If I only need to know:

```text
"Have I seen this value?"
```

Use:

```text
HashSet
```

If I need:

```text
"Where did I see this value?"
```

Use:

```text
HashMap
```

The core pattern is:

```text
Current Element
      ↓
Have I Seen It?
   ↙       ↘
 Yes        No
  ↓          ↓
Duplicate   Store It
```

---

# ⏱️ Complexity

```text
Time Complexity: O(n)

Space Complexity: O(n)
```

### Why Time is O(n)?

We traverse the array once.

Each `HashSet` operation:

```text
contains()
add()
```

has expected `O(1)` time complexity.

Therefore:

```text
n × O(1) = O(n)
```

### Why Space is O(n)?

In the worst case, all elements are unique.

The `HashSet` will store all `n` elements.

Therefore:

```text
O(n)
```

---

# 📊 Problem Status

```text
First Attempt: Needed Debugging
Data Structure Recognition: HashMap → HashSet
Pattern Recognized: Yes
Algorithm Recognized: Yes
Java Implementation: Correct
Needed Hint: Yes
Current Status: 🟢 Solved
```

### 🔁 Revision Schedule

```text
First Solve: Day 0
Revision 1: Day 1
Revision 2: Day 3
Revision 3: Day 7
Revision 4: Day 14
Revision 5: Day 30
```

---

# 🎯 Pattern to Remember

```text
Problem:
"Have I seen this before?"

        ↓

Use HashSet

        ↓

Check contains()

        ↓

If yes → Duplicate

        ↓

If no → Add to Set
```

**Mental Trigger:**

> "Have I seen this element before?" → **HashSet**
