# Best Time to Buy and Sell Stock

**LeetCode Problem:** #121
**Difficulty:** Easy
**Data Structure:** Array
**Pattern:** Greedy / One-Pass Scanning
**Language:** Java

---

## 🧠 Problem in Simple Words

You are given an array where each element represents the stock price on a particular day.

You can:

1. Buy the stock only once.
2. Sell the stock only once.
3. You must buy before you sell.

Your goal is to find the **maximum profit** you can make.

If you cannot make any profit, return `0`.

### Example

```text
Input:
prices = [7, 1, 5, 3, 6, 4]

Output:
5
```

The best decision is:

```text
Buy at 1
Sell at 6

Profit = 6 - 1
       = 5
```

---

# 🐢 Brute Force Approach

The brute force approach is to try every possible pair of days.

For every possible buying day:

1. Consider buying the stock on that day.
2. Check every day after it as a possible selling day.
3. Calculate the profit.
4. Keep track of the maximum profit.

For example:

```text
Buy at index i
Sell at index j

Profit = prices[j] - prices[i]
```

We need to make sure:

```text
i < j
```

because we must buy before selling.

### Brute Force Pseudocode

```text
maxProfit = 0

For every buying day i:

    For every selling day j after i:

        Calculate:
        prices[j] - prices[i]

        Update maxProfit

Return maxProfit
```

### Brute Force Complexity

```text
Time Complexity: O(n²)
Space Complexity: O(1)
```

The problem with this approach is that we check almost every possible pair of days.

---

# 🚀 Optimized Approach

Instead of checking every possible pair, we can solve the problem in **one pass** through the array.

The key observation is:

> To maximize profit when selling today, we should have bought at the cheapest price seen before today.

So while traversing the array, we maintain two things:

### 1. Minimum Buying Price

The cheapest stock price seen so far.

```text
buying
```

### 2. Maximum Profit

The maximum profit found so far.

```text
profit
```

For every price:

```text
1. Update the minimum buying price.

2. Calculate the profit if we sell today.

3. Update the maximum profit.
```

The formula for today's profit is:

```text
Current Price - Minimum Buying Price
```

---

# 🔍 Dry Run

Consider:

```text
prices = [7, 1, 5, 3, 6, 4]
```

Initially:

```text
buying = ∞
profit = 0
```

### Day 1

```text
Price = 7

Minimum buying price = 7
Current profit = 0
Maximum profit = 0
```

### Day 2

```text
Price = 1

Minimum buying price = 1
Current profit = 0
Maximum profit = 0
```

### Day 3

```text
Price = 5

Minimum buying price = 1

Current profit:
5 - 1 = 4

Maximum profit = 4
```

### Day 4

```text
Price = 3

Minimum buying price = 1

Current profit:
3 - 1 = 2

Maximum profit = 4
```

### Day 5

```text
Price = 6

Minimum buying price = 1

Current profit:
6 - 1 = 5

Maximum profit = 5
```

### Day 6

```text
Price = 4

Minimum buying price = 1

Current profit:
4 - 1 = 3

Maximum profit = 5
```

Final answer:

```text
5
```

---

# 💡 Key Insight

The most important idea is:

> **Always remember the cheapest price encountered so far.**

When you reach a new price, imagine selling today.

The best possible profit for today is:

```text
Today's Price - Cheapest Previous Price
```

Then compare today's profit with the best profit found so far.

This allows us to solve the problem with only one traversal.

---

# 🔎 Pattern Recognition

When you see a problem involving:

* An array representing values over time
* Making one decision before another
* Finding the maximum difference
* Processing elements from left to right
* Only needing information from the past

Think about:

```text
One-Pass Scanning
```

A common technique is:

```text
Track the minimum / maximum seen so far
+
Calculate the best result using the current element
```

This is also commonly viewed as a **Greedy** approach because at every position we maintain the best local information needed to make the optimal global decision.

---

# 💻 Java Implementation

```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buying = Integer.MAX_VALUE;
        int curr_profit = 0;
        int i = 0;

        while (i < prices.length) {
            buying = Math.min(buying, prices[i]);

            if (prices[i] > buying) {
                curr_profit = prices[i] - buying;
            }

            profit = Math.max(profit, curr_profit);

            i++;
        }

        return profit;
    }
}
```

---

# ⏱️ Complexity

```text
Time Complexity: O(n)

Space Complexity: O(1)
```

### Why?

We traverse the array only once.

```text
n elements
↓
One pass
↓
O(n)
```

We only use a few variables:

```text
buying
curr_profit
profit
i
```

Therefore:

```text
Extra Space = O(1)
```

---

# ❌ My Mistakes During First Attempt

### Mistake 1: Incorrect Java Constant

Initially used:

```java
INTEGER.MAX_VALUE
```

Correct:

```java
Integer.MAX_VALUE
```

Java is case-sensitive.

---

### Mistake 2: Forgot to Initialize `profit`

Initially:

```java
int profit;
```

A local variable must be initialized before it is used.

Correct:

```java
int profit = 0;
```

---

### Mistake 3: Stored the Stock Price Instead of Profit

Initially tried to update the maximum using:

```text
prices[i]
```

But the problem asks for the maximum **profit**, not the maximum stock price.

Correct calculation:

```text
Current Price - Minimum Buying Price
```

---

### Mistake 4: Forgot to Declare `i`

Initially used:

```java
while (i < prices.length)
```

without declaring `i`.

Correct:

```java
int i = 0;
```

---

### Mistake 5: Forgot to Increment `i`

The loop needs to move to the next element:

```java
i++;
```

---

# 🧠 What I Learned

The key lesson from this problem is:

> I don't need to compare every possible buying and selling pair.

Instead, while moving through the array, I only need to remember:

```text
The cheapest price seen so far
```

Then for every current price:

```text
Potential Profit =
Current Price - Cheapest Price Seen So Far
```

Finally, I keep track of the maximum profit found.

This changes the solution from:

```text
O(n²)
```

to:

```text
O(n)
```

---

# 📊 Problem Status

```text
First Attempt: Needed Debugging
Pattern Recognized: Yes
Algorithm Recognized: Yes
Java Implementation: Needed Correction
Solution Implemented: Yes
Time Complexity: O(n)
Space Complexity: O(1)
Current Status: 🟡 Learning
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
Array
   ↓
One-Pass Scan
   ↓
Track Minimum/Maximum So Far
   ↓
Calculate Current Best
   ↓
Update Global Best
```

**Mental Trigger:**

> "Can I solve this by remembering the best value I've seen so far?"
