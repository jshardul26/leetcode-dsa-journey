# 238. Product of Array Except Self

## 🔗 Problem

Given an integer array `nums`, return an array `answer` such that:

- `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.
- The algorithm must run in **O(n)** time.
- **Division is not allowed.**

---

## 💡 Example

### Input

```text
nums = [1,2,3,4]
```

### Output

```text
[24,12,8,6]
```

### Explanation

```text
answer[0] = 2 × 3 × 4 = 24
answer[1] = 1 × 3 × 4 = 12
answer[2] = 1 × 2 × 4 = 8
answer[3] = 1 × 2 × 3 = 6
```

---

## 🧠 Intuition

Instead of multiplying every element except the current one repeatedly, we split the calculation into two parts:

- Product of all elements to the **left**
- Product of all elements to the **right**

For every index:

```text
Answer[i] = Left Product × Right Product
```

We first store the prefix (left) products in the answer array.

Then we traverse from right to left while maintaining a suffix product and multiply it with the prefix product.

This avoids using division and achieves an O(n) solution.

---

## 🚀 Algorithm

1. Create an answer array.
2. Store prefix products in the answer array.
3. Traverse from right to left while maintaining a suffix product.
4. Multiply the suffix product with the existing prefix product.
5. Return the answer array.

---

## ⏱️ Complexity Analysis

**Time Complexity:** `O(n)`

- One pass for prefix products.
- One pass for suffix products.

**Space Complexity:** `O(1)` extra space

- The output array is not counted as extra space.
- Only one additional variable (`suffix`) is used.

---

## 🏷️ Pattern

- Prefix Product
- Suffix Product
- Array
- Simulation

---

## 📚 Key Learning

- Prefix and suffix computations can eliminate nested loops.
- Some problems that appear to require division can be solved without it.
- Reusing the output array helps achieve constant extra space.

---

## ✅ Status

Solved using Prefix & Suffix Product technique.
