# 125. Valid Palindrome

## 🧩 Problem

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

A palindrome is a string that reads the same forward and backward.

For this problem:

* Ignore uppercase and lowercase letters.
* Ignore all non-alphanumeric characters.

### Example

**Input:**

```text
s = "A man, a plan, a canal: Panama"
```

**Output:**

```text
true
```

**Explanation:**

After removing non-alphanumeric characters and converting everything to lowercase:

```text
"amanaplanacanalpanama"
```

This reads the same forward and backward.

---

## 🎯 Pattern

* **Data Structure:** String
* **Algorithm:** Two Pointers
* **Difficulty:** Easy
* **LeetCode:** 125. Valid Palindrome

---

## 💡 Approach

We use two pointers:

```text
left  → starts from the beginning
right → starts from the end
```

### Step 1: Initialize pointers

```text
left = 0
right = s.length() - 1
```

### Step 2: Move pointers

If the character at `left` is not alphanumeric, move `left` forward.

If the character at `right` is not alphanumeric, move `right` backward.

### Step 3: Compare characters

Convert both characters to lowercase and compare them.

If they are different:

```text
return false
```

### Step 4: Move inward

If they are equal:

```text
left++
right--
```

Continue until:

```text
left >= right
```

If no mismatch is found:

```text
return true
```

---

## 🧠 Pseudocode

```text
left = 0
right = length of string - 1

while left < right:

    while left < right AND s[left] is not alphanumeric:
        left++

    while left < right AND s[right] is not alphanumeric:
        right--

    if lowercase(s[left]) != lowercase(s[right]):
        return false

    left++
    right--

return true
```

---

## ☕ Java Solution

```java
class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
```

---

## 🔍 Dry Run

### Input

```text
s = "A man, a plan, a canal: Panama"
```

We compare characters from both ends:

```text
A == a  ✓
m == m  ✓
a == a  ✓
n == n  ✓
a == a  ✓
p == p  ✓
l == l  ✓
a == a  ✓
n == n  ✓
a == a  ✓
```

Non-alphanumeric characters such as:

```text
' '
','
':'
```

are skipped.

No mismatch is found.

Therefore:

```text
Output = true
```

---

## ⏱️ Complexity Analysis

### Time Complexity

```text
O(n)
```

Each character is processed at most a constant number of times.

### Space Complexity

```text
O(1)
```

We use only two pointers and do not create another string.

---

## 🔑 Key Takeaways

1. Use **Two Pointers** when comparing elements from both ends.
2. `Character.isLetterOrDigit()` helps ignore special characters.
3. `Character.toLowerCase()` allows case-insensitive comparison.
4. We can solve the problem **in-place without creating a cleaned string**.
5. This approach achieves **O(n) time and O(1) extra space**.

---

## 🧠 Pattern Recognition

Think of **Two Pointers** when:

* You need to compare the beginning and end of a string.
* You need to check whether something is symmetric.
* You need to process an array from both ends.
* You need to find pairs in a sorted array.

### Similar Problems

* Valid Palindrome II
* Two Sum II – Input Array Is Sorted
* Container With Most Water
* 3Sum
* Reverse String

---

## 🚀 Learning Progress

* [x] Understand the problem
* [x] Identify Two Pointer pattern
* [x] Write pseudocode
* [x] Implement Java solution
* [x] Analyze time and space complexity
* [ ] Solve without looking at the solution
* [ ] Reattempt after 24 hours
* [ ] Reattempt after 7 days

