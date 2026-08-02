# Two Sum

**LeetCode:** #1  
**Difficulty:** Easy  
**Data Structure:** Array + HashMap  
**Pattern:** Complement Lookup

---

## 🧠 Problem in Simple Words

You are given an array of numbers and a target number.

You need to find two different numbers whose sum equals the target.

Return the indexes of those two numbers.

For example:

nums = [2, 7, 11, 15]
target = 9

2 + 7 = 9

So the answer is:

[0, 1]

---

## 💡 Key Idea

For every number, calculate:

target - currentNumber

This tells us the number we need to find.

We use a HashMap to remember numbers we have already seen and their indexes.

---

## 🐢 Brute Force Approach

Check every possible pair.

For every `i`, check every `j`.

### Time Complexity

O(n²)

### Space Complexity

O(1)

---

## 🚀 Optimized Approach

Use a HashMap.

Store:

number → index

For every number:

1. Calculate the required number.
2. Check if it already exists in the HashMap.
3. If it exists, return the two indexes.
4. Otherwise, store the current number and index.

---

## 🔍 Dry Run

nums = [2, 7, 11, 15]
target = 9

i = 0
current = 2
required = 7

7 is not in HashMap.

Store:

2 → 0

---

i = 1
current = 7
required = 2

2 exists in HashMap.

2 → 0

Current index = 1

Answer:

[0, 1]

---

## ⏱️ Complexity

Time: O(n)

Space: O(n)

---

## 🧠 Pattern Recognition

When you see:

- Find two values
- Need a specific relationship between them
- Need fast lookup

Think:

HashMap

Often calculate:

target - current


## ❌ My Mistakes

1. Tried sorting the array and using two pointers.
2. Forgot that sorting changes the original indexes.
3. Used `nums.length` instead of `nums.length - 1`.
4. Forgot the correct Java syntax for `Arrays.sort()`.
5. Used `getKey()` instead of `get()`.
6. Returned `[-1, -1]` inside the loop instead of after checking all elements.
7. Initially used two loops instead of realizing that checking and storing can happen in one pass.
