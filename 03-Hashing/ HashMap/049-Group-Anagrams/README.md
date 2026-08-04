# LeetCode #49 — Group Anagrams

## 📌 Problem

Given an array of strings `strs`, group the anagrams together.

The order of the output does not matter.

### Example

**Input:**

```text
["eat", "tea", "tan", "ate", "nat", "bat"]
```

**Output:**

```text
[
    ["eat", "tea", "ate"],
    ["tan", "nat"],
    ["bat"]
]
```

---

## 🧠 Problem Understanding

Two strings are anagrams if they contain the same characters with the same frequency, but their order can be different.

For example:

```text
eat
tea
ate
```

All three strings contain:

```text
a → 1
e → 1
t → 1
```

Therefore, they belong to the same group.

Similarly:

```text
tan
nat
```

are anagrams and belong to another group.

---

## 💡 Key Idea

We need a way to identify anagrams.

If we sort the characters of every string, all anagrams will produce the same sorted string.

For example:

```text
eat → aet
tea → aet
ate → aet

tan → ant
nat → ant

bat → abt
```

Therefore, the sorted string can be used as a unique key.

We can use a `HashMap` where:

```text
Key   → Sorted version of the string
Value → List of original strings
```

The map will look conceptually like:

```text
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan", "nat"]
"abt" → ["bat"]
```

---

## 🔑 Data Structure

```java
HashMap<String, List<String>>
```

### Why?

We need to map one key to multiple strings.

For example:

```text
"aet"
  ↓
["eat", "tea", "ate"]
```

Therefore:

```text
String
   ↓
List<String>
```

is stored in the HashMap.

---

## 📝 Algorithm

1. Create a `HashMap<String, List<String>>`.
2. Iterate through every string in the input array.
3. Convert the current string into a character array.
4. Sort the character array.
5. Convert the sorted character array back into a `String`.
6. Use the sorted string as the HashMap key.
7. Add the original string to the list associated with that key.
8. Return all the values from the HashMap.

---

## 🔍 Example Walkthrough

Input:

```text
["eat", "tea", "tan", "ate", "nat", "bat"]
```

### Step 1

Process `"eat"`:

```text
eat → aet
```

Map:

```text
aet → ["eat"]
```

### Step 2

Process `"tea"`:

```text
tea → aet
```

Same key:

```text
aet → ["eat", "tea"]
```

### Step 3

Process `"tan"`:

```text
tan → ant
```

New key:

```text
aet → ["eat", "tea"]
ant → ["tan"]
```

### Step 4

Process `"ate"`:

```text
ate → aet
```

Map:

```text
aet → ["eat", "tea", "ate"]
ant → ["tan"]
```

### Step 5

Process `"nat"`:

```text
nat → ant
```

Map:

```text
aet → ["eat", "tea", "ate"]
ant → ["tan", "nat"]
```

### Step 6

Process `"bat"`:

```text
bat → abt
```

Final map:

```text
aet → ["eat", "tea", "ate"]
ant → ["tan", "nat"]
abt → ["bat"]
```

Return the values of the map.

---

## 💻 Java Methods Used

### `toCharArray()`

Converts a String into a character array.

```java
char[] chars = str.toCharArray();
```

Example:

```text
"eat"
 ↓
['e', 'a', 't']
```

---

### `Arrays.sort()`

Sorts the character array.

```java
Arrays.sort(chars);
```

Example:

```text
['e', 'a', 't']
 ↓
['a', 'e', 't']
```

---

### `new String()`

Converts the sorted character array back into a String.

```java
String key = new String(chars);
```

Example:

```text
['a', 'e', 't']
 ↓
"aet"
```

---

### `computeIfAbsent()`

This method can be used to create a new list if a key doesn't already exist.

Conceptually:

```text
If key exists:
    Get its existing list

If key doesn't exist:
    Create a new ArrayList
```

Then the original string can be added to that list.

---

## ⏱️ Time Complexity

Let:

* `N` = number of strings
* `K` = maximum length of a string

For each string, we sort its characters.

Sorting one string takes:

```text
O(K log K)
```

For `N` strings:

```text
O(N × K log K)
```

### Time Complexity

```text
O(N × K log K)
```

### Space Complexity

```text
O(N × K)
```

The space is used to store the grouped strings and the HashMap.

---

## 🔥 Pattern Learned

### Pattern: HashMap + Canonical Representation

The important idea is:

```text
Different inputs
      ↓
Convert into a common representation
      ↓
Use common representation as HashMap key
      ↓
Group similar inputs
```

For this problem:

```text
"eat" → "aet"
"tea" → "aet"
"ate" → "aet"
```

Therefore:

```text
"aet" → ["eat", "tea", "ate"]
```

---

## 🧠 Key Takeaway

The most important lesson from this problem is:

> When multiple objects need to be grouped based on some property, try to create a common key that represents that property.

Here, the sorted string acts as the **canonical representation** of an anagram.

```text
Anagrams
    ↓
Same characters
    ↓
Sort characters
    ↓
Same sorted string
    ↓
Use sorted string as HashMap key
```

---

## 🔗 Related Problems

* LeetCode #1 — Two Sum
* LeetCode #217 — Contains Duplicate
* LeetCode #242 — Valid Anagram

These problems help build the foundation for:

```text
HashMap
HashSet
Frequency Counting
Canonical Representation
Grouping
```

---

## 📈 Difficulty

**Medium**

## 🏷️ Pattern

```text
HashMap
Hashing
Sorting
Canonical Representation
Grouping
```

## 🎯 Status

* [ ] Attempted
* [ ] Solved Independently
* [ ] Reattempted
* [ ] Revised
* [ ] Mastered
