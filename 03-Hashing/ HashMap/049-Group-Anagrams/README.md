# Group Anagrams

**LeetCode Problem:** #49
**Difficulty:** Medium
**Data Structure:** HashMap
**Pattern:** Hashing / Grouping / Anagram
**Language:** Java

---

## 🧠 Problem in Simple Words

You are given an array of strings.

Your task is to group all strings that are **anagrams** of each other.

Two strings are anagrams if they contain the same characters with the same frequencies, but their order can be different.

### Example

```text
Input:
["eat", "tea", "tan", "ate", "nat", "bat"]
```

Output:

```text
[
    ["eat", "tea", "ate"],
    ["tan", "nat"],
    ["bat"]
]
```

The order of the groups does not matter.

---

# 🔍 Understanding the Example

Consider:

```text
"eat"
"tea"
"ate"
```

All three contain:

```text
a → 1
e → 1
t → 1
```

Therefore, they are anagrams and belong to the same group.

Similarly:

```text
"tan"
"nat"
```

contain:

```text
a → 1
n → 1
t → 1
```

So they belong to another group.

Finally:

```text
"bat"
```

has a different character composition, so it forms its own group.

---

# 🐢 Brute Force Approach

One possible brute-force approach is to compare every string with other strings and determine whether they are anagrams.

We could use the logic from **Valid Anagram #242** to check whether two strings are anagrams.

The general idea would be:

```text
For every string:

    Compare it with other strings

    If two strings are anagrams:
        Put them in the same group
```

The problem is that we may need to compare many pairs of strings.

If there are `n` strings and each string has length `k`, repeatedly checking anagrams becomes expensive.

---

# 🚀 Optimized Approach — Sorting as a Key

The key observation is:

> Anagrams produce the same sorted string.

For example:

```text
"eat" → "aet"
"tea" → "aet"
"ate" → "aet"
```

Therefore, all three strings can use:

```text
"aet"
```

as the same HashMap key.

Similarly:

```text
"tan" → "ant"
"nat" → "ant"
```

Both use:

```text
"ant"
```

as their key.

And:

```text
"bat" → "abt"
```

uses:

```text
"abt"
```

as its key.

So we can use:

```text
Sorted String → List of Original Strings
```

For example:

```text
"aet" → ["eat", "tea", "ate"]

"ant" → ["tan", "nat"]

"abt" → ["bat"]
```

---

# 🧠 Key Idea

For every string:

```text
Original String
       ↓
Convert to character array
       ↓
Sort characters
       ↓
Create sorted string
       ↓
Use sorted string as HashMap key
       ↓
Add original string to its group
```

The important point is:

> We use the **sorted version** as the key, but we store the **original string** in the group.

For example:

```text
Original:
"tea"

Sorted:
"aet"
```

We use:

```text
"aet"
```

as the key.

But we store:

```text
"tea"
```

in the result.

---

# 🗺️ Example Dry Run

Input:

```text
["eat", "tea", "tan", "ate", "nat", "bat"]
```

Initially:

```text
Map = {}
```

### 1. `"eat"`

Sort:

```text
"eat" → "aet"
```

Map:

```text
"aet" → ["eat"]
```

---

### 2. `"tea"`

Sort:

```text
"tea" → "aet"
```

The key already exists.

Add `"tea"`:

```text
"aet" → ["eat", "tea"]
```

---

### 3. `"tan"`

Sort:

```text
"tan" → "ant"
```

New key:

```text
"ant" → ["tan"]
```

---

### 4. `"ate"`

Sort:

```text
"ate" → "aet"
```

Add to existing group:

```text
"aet" → ["eat", "tea", "ate"]
```

---

### 5. `"nat"`

Sort:

```text
"nat" → "ant"
```

Add to existing group:

```text
"ant" → ["tan", "nat"]
```

---

### 6. `"bat"`

Sort:

```text
"bat" → "abt"
```

New group:

```text
"abt" → ["bat"]
```

Final HashMap:

```text
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan", "nat"]
"abt" → ["bat"]
```

The final answer is the collection of all the values.

---

# 💻 Java Implementation

```java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string to character array
            char[] chars = str.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Sorted string becomes the key
            String key = new String(chars);

            // Add original string to corresponding group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
```

---

# 🔑 Important Java Methods

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

### `new String(chars)`

Converts the sorted character array back into a String.

```java
String key = new String(chars);
```

Result:

```text
"aet"
```

---

### `putIfAbsent()`

This is useful when creating a new group.

```java
map.putIfAbsent(key, new ArrayList<>());
```

Meaning:

> If this key doesn't exist, create an empty list for it.

Example:

```text
Before:
{}

After:
"aet" → []
```

If `"aet"` already exists, it does nothing.

---

### `map.get(key).add(str)`

First:

```java
map.get(key)
```

gets the list associated with the key.

Then:

```java
.add(str)
```

adds the original string to that list.

For example:

```text
"aet" → ["eat", "tea"]
```

Adding `"ate"` gives:

```text
"aet" → ["eat", "tea", "ate"]
```

---

### `map.values()`

Returns all the groups.

Example:

```text
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan", "nat"]
"abt" → ["bat"]
```

`map.values()` gives:

```text
[
    ["eat", "tea", "ate"],
    ["tan", "nat"],
    ["bat"]
]
```

We convert it to an `ArrayList`:

```java
new ArrayList<>(map.values())
```

---

# ⏱️ Complexity Analysis

Let:

* `n` = number of strings
* `k` = maximum length of a string

For every string, we sort its characters.

Sorting one string takes:

```text
O(k log k)
```

For `n` strings:

```text
O(n × k log k)
```

### Time Complexity

```text
O(n × k log k)
```

### Space Complexity

```text
O(n × k)
```

The HashMap stores all strings in groups, and the sorted keys also require space.

---

# 🧠 Pattern Recognition

When you see:

> "Group anagrams"

Think:

```text
Anagrams
    ↓
Need same identity
    ↓
Create canonical key
    ↓
Sort characters
    ↓
Use sorted string as HashMap key
    ↓
HashMap<String, List<String>>
```

The key pattern is:

> **Canonical Representation + HashMap**

Different inputs that are logically equivalent are transformed into the same representation.

Example:

```text
eat → aet
tea → aet
ate → aet
```

Therefore:

```text
aet → same group
```

---

# 🔥 Connection to Valid Anagram #242

This problem directly builds on the previous problem.

### Valid Anagram #242

Question:

> Are these two strings anagrams?

We learned:

```text
Same characters
+
Same frequencies
=
Anagram
```

### Group Anagrams #49

Question:

> Which strings are anagrams of each other?

We use the same concept:

```text
Same characters
+
Same frequencies
=
Same Group
```

The difference is that instead of comparing two strings, we create a **common key** that represents their character composition.

---

# 🧠 Key Takeaway

The most important idea from this problem is:

> **When multiple inputs share the same property, try to create a common key that represents that property.**

For anagrams:

```text
"eat"
"tea"
"ate"
```

All become:

```text
"aet"
```

So:

```text
Sorted String
      ↓
HashMap Key
      ↓
List of Original Strings
```

Mental trigger:

> **Group similar things → Find a common key → Use HashMap**

---

# 📌 Problem Status

```text
Problem: Group Anagrams
LeetCode: #49
Difficulty: Medium

Pattern:
Hashing + Canonical Representation

Data Structure:
HashMap<String, List<String>>

Approach:
Sort each string → Use sorted string as key

Status:
🟡 Learning / Implementation
```

---

# 🔄 Revision Notes

This problem should be connected with:

```text
#1   Two Sum
#217 Contains Duplicate
#242 Valid Anagram
#49  Group Anagrams
```

Together, these problems teach important Hashing patterns:

```text
Two Sum
    ↓
HashMap for lookup

Contains Duplicate
    ↓
HashSet for seen values

Valid Anagram
    ↓
Frequency Counting

Group Anagrams
    ↓
Canonical Key + HashMap Grouping
```

This is a very important progression in your DSA journey.

