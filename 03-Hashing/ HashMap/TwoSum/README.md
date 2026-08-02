## Two Sum — Detailed & Easy Explanation

The **Two Sum** problem is one of the most important beginner problems on LeetCode because it teaches you a very useful pattern: **using a HashMap to find a required value quickly**.

---

### 🟢 Problem Statement

You are given:

* An integer array `nums`
* An integer `target`

You need to find **two different elements** in the array whose sum is equal to `target`.

Return the **indices** of those two elements.

### Example

```text
nums = [2, 7, 11, 15]
target = 9
```

We need to find:

```text
2 + 7 = 9
```

The index of `2` is `0`.

The index of `7` is `1`.

So the answer is:

```text
[0, 1]
```

---

# 1. Brute Force Approach

The simplest way is to check **every possible pair**.

For every element, we check all the elements after it.

### Example

```text
nums = [2, 7, 11, 15]
target = 9
```

We start with `2`.

We need:

```text
target - 2
= 9 - 2
= 7
```

Now we check whether `7` exists after `2`.

Yes!

So:

```text
2 + 7 = 9
```

Return:

```text
[0, 1]
```

### Pseudocode

```text
for i = 0 to n-1
    for j = i+1 to n-1

        if nums[i] + nums[j] == target
            return [i, j]

return [-1, -1]
```

### Time Complexity

```text
O(n²)
```

Because we potentially check every pair.

### Space Complexity

```text
O(1)
```

We don't use any extra data structure.

---

# 2. Optimized Approach — HashMap

Now let's think differently.

Suppose:

```text
nums = [2, 7, 11, 15]
target = 9
```

We are currently looking at:

```text
2
```

We need another number such that:

```text
2 + x = 9
```

So:

```text
x = 9 - 2
x = 7
```

This required number is called the **complement**.

So the main idea is:

> For every number, calculate its complement and check whether we have already seen that complement.

---

## Step-by-Step Example

```text
nums = [2, 7, 11, 15]
target = 9
```

We create an empty HashMap:

```text
map = {}
```

The HashMap will store:

```text
number -> index
```

---

### Step 1

Current number:

```text
nums[0] = 2
```

Calculate complement:

```text
complement = target - current
complement = 9 - 2
complement = 7
```

Now check:

```text
Does map contain 7?
```

No.

So store `2` and its index:

```text
map = {
    2 -> 0
}
```

---

### Step 2

Current number:

```text
nums[1] = 7
```

Calculate complement:

```text
complement = 9 - 7
complement = 2
```

Now check:

```text
Does map contain 2?
```

Yes!

The HashMap tells us:

```text
2 -> 0
```

And the current number `7` is at index:

```text
1
```

Therefore:

```text
return [0, 1]
```

---

# The Important Pattern

The entire logic can be remembered as:

```text
Current Number
      ↓
Calculate Complement
      ↓
target - current
      ↓
Have I seen Complement Before?
      ↓
     YES ─────→ Return Both Indices
      │
      NO
      ↓
Store Current Number + Index
```

The most important line is:

```java
int complement = target - nums[i];
```

For example:

```text
target = 10
current = 4

complement = 10 - 4
           = 6
```

We are basically asking:

> "I have `4`. Have I already seen `6`?"

If yes:

```text
4 + 6 = 10
```

We found our answer.

---

# Java Code

```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
```

---

# Dry Run

Let's take:

```text
nums = [3, 2, 4]
target = 6
```

### Initially

```text
map = {}
```

### `i = 0`

```text
nums[i] = 3
```

Complement:

```text
6 - 3 = 3
```

Does map contain `3`?

```text
No
```

Store:

```text
map = {3 -> 0}
```

---

### `i = 1`

```text
nums[i] = 2
```

Complement:

```text
6 - 2 = 4
```

Does map contain `4`?

```text
No
```

Store:

```text
map = {
    3 -> 0,
    2 -> 1
}
```

---

### `i = 2`

```text
nums[i] = 4
```

Complement:

```text
6 - 4 = 2
```

Does map contain `2`?

```text
Yes
```

Map says:

```text
2 -> 1
```

Current index:

```text
i = 2
```

Therefore:

```text
return [1, 2]
```

Because:

```text
nums[1] + nums[2]
= 2 + 4
= 6
```

---

# Why Do We Check Before Putting?

This is an important detail.

We do:

```java
if (map.containsKey(complement)) {
    return new int[] {map.get(complement), i};
}

map.put(nums[i], i);
```

Instead of immediately storing the current number.

This ensures that we always use **two different elements**.

For example:

```text
nums = [3, 3]
target = 6
```

At index `0`:

```text
current = 3
complement = 3
```

The map is empty, so we store:

```text
3 -> 0
```

At index `1`:

```text
current = 3
complement = 3
```

Now we find:

```text
3 -> 0
```

So answer:

```text
[0, 1]
```

We correctly use two different positions.

---

# Complexity Comparison

| Approach    |           Time |  Space |
| ----------- | -------------: | -----: |
| Brute Force |        `O(n²)` | `O(1)` |
| HashMap     | `O(n)` average | `O(n)` |

The HashMap approach is faster because checking:

```java
map.containsKey(key)
```

takes **O(1) average time**.

---

# Key Takeaway

The **Two Sum pattern** is:

```text
1. Start with an empty HashMap.
2. Traverse the array once.
3. Calculate:
      complement = target - current
4. Check if complement exists in HashMap.
5. If yes → return its index and current index.
6. If no → store current number and its index.
```

### The formula to remember:

> **Required Number = Target − Current Number**

This pattern is extremely useful in many problems involving **arrays, HashMaps, pairs, complements, and frequency tracking**.

### One-line interview explanation

> "I traverse the array once while storing previously seen numbers and their indices in a HashMap. For each current number, I calculate `target - current` and check whether that complement has already been seen. If it has, I return the two indices; otherwise, I store the current number and continue."

