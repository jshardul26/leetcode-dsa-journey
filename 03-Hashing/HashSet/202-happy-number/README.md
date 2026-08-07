# LeetCode 202 — Happy Number

## Problem

Write an algorithm to determine if a number `n` is a **happy number**.

A happy number is a number defined by the following process:

1. Start with any positive integer.
2. Replace the number by the sum of the squares of its digits.
3. Repeat the process until the number becomes `1`.
4. If the process enters a cycle that does not include `1`, the number is not happy.

Return `true` if `n` is a happy number, otherwise return `false`.

---

## Example 1

### Input

```text
n = 19
```

### Process

```text
19
↓
1² + 9² = 82
↓
8² + 2² = 68
↓
6² + 8² = 100
↓
1² + 0² + 0² = 1
```

### Output

```text
true
```

---

## Example 2

### Input

```text
n = 2
```

### Process

```text
2 → 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 → ...
```

The sequence repeats, creating a cycle.

### Output

```text
false
```

---

## Approach

The important observation is that there are only two possible outcomes:

### Case 1 — We reach `1`

The number is a happy number.

```text
n → ... → 1
```

Return:

```text
true
```

### Case 2 — We enter a cycle

If a number appears again, the process will repeat forever.

For example:

```text
4 → 16 → 37 → ... → 20 → 4
```

We can use a `HashSet` to remember every number we have already encountered.

If we see the same number again, we know that we are inside a cycle.

Return:

```text
false
```

---

## Algorithm

1. Create a `HashSet` called `seen`.
2. Continue while `n != 1`.
3. If `n` already exists in `seen`, return `false`.
4. Add `n` to `seen`.
5. Calculate the sum of the squares of its digits.
6. Store the calculated sum back in `n`.
7. If `n` becomes `1`, return `true`.

---

## Java Code

```java
import java.util.*;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {

            // Cycle detected
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);

            int sum = 0;

            // Calculate sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }
}
```

---

## How Digit Extraction Works

The following operations help us extract each digit:

```java
int digit = n % 10;
n /= 10;
```

For example:

```text
n = 19

19 % 10 = 9
19 / 10 = 1

1 % 10 = 1
1 / 10 = 0
```

Therefore:

```text
9² + 1²
= 81 + 1
= 82
```

---

## Complexity Analysis

Let `d` represent the number of digits involved in each transformation.

The number of possible transformed values becomes very small, so the process quickly either reaches `1` or repeats.

### Time Complexity

Approximately:

```text
O(log n)
```

per digit transformation, with a small bounded number of transformations in practice.

### Space Complexity

```text
O(k)
```

where `k` is the number of unique values stored in the `HashSet`.

---

## Key Pattern

### HashSet + Cycle Detection

This problem teaches an important pattern:

```text
Repeated transformation
        ↓
Remember previous states
        ↓
HashSet
        ↓
Seen before?
   ↙          ↘
 YES           NO
  ↓             ↓
Cycle        Continue
```

### Pattern to Remember

```text
If a process keeps changing a value and
you need to detect whether it repeats:

→ Use HashSet
→ Store every previous state
→ If state appears again → Cycle
```

---

## Important Java Methods

| Method             | Purpose                         |
| ------------------ | ------------------------------- |
| `seen.add(n)`      | Store a value                   |
| `seen.contains(n)` | Check if value was already seen |

---

## Related Problems

* LeetCode 202 — Happy Number
* LeetCode 141 — Linked List Cycle
* LeetCode 287 — Find the Duplicate Number
* LeetCode 128 — Longest Consecutive Sequence
* LeetCode 349 — Intersection of Two Arrays

---

## Key Takeaway

The main idea is **not just calculating the digit squares**.

The important DSA concept is:

> **Use a HashSet to detect repeated states and identify cycles.**

