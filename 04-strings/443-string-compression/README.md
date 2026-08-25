# 443. String Compression

## Difficulty

Medium

---

## Pattern

Strings, Two Pointers, In-place Array Manipulation

---

## Problem

Given an array of characters `chars`, compress it **in-place**.

For each group of consecutive repeating characters:

- Write the character once.
- If the count is greater than `1`, write the count as separate characters.
- Return the new length of the compressed array.

---

## Approach

Use two pointers:

- **read** → Traverses the array and counts consecutive characters.
- **write** → Writes the compressed result back into the same array.

For each group:

1. Count consecutive occurrences.
2. Write the character once.
3. If the count is greater than one, convert the count to a string and write each digit separately.

---

## Algorithm

1. Initialize `read = 0` and `write = 0`.
2. While `read < chars.length`:
   - Store the current character.
   - Count consecutive occurrences.
   - Write the character.
   - If count > 1:
     - Convert count to a string.
     - Write every digit into the array.
3. Return `write`.

---

## Java Solution

```java
class Solution {
    public int compress(char[] chars) {

        int write = 0;
        int read = 0;

        while (read < chars.length) {

            char current = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {
                String cnt = String.valueOf(count);

                for (char c : cnt.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
```

---

## Example 1

### Input

```
['a','a','b','b','c','c','c']
```

### Output

```
6
```

Compressed array:

```
['a','2','b','2','c','3']
```

---

## Example 2

### Input

```
['a']
```

### Output

```
1
```

Compressed array:

```
['a']
```

---

## Example 3

### Input

```
['a','b','b','b','b','b','b','b','b','b','b','b','b']
```

### Output

```
4
```

Compressed array:

```
['a','b','1','2']
```

---

## Dry Run

Input:

```
[a,a,b,b,c,c,c]
```

Process groups:

```
aa  -> a2
bb  -> b2
ccc -> c3
```

Final array:

```
[a,2,b,2,c,3]
```

Return:

```
6
```

---

## Time Complexity

```
O(n)
```

Each character is visited exactly once.

---

## Space Complexity

```
O(1)
```

Compression is performed in-place. Only a few extra variables are used.

---

## Java Methods Used

| Method | Purpose |
|---------|---------|
| `String.valueOf(int)` | Convert count into a string |
| `toCharArray()` | Traverse each digit of the count |

---

## Concepts Learned

- Two Pointers
- Read Pointer / Write Pointer
- In-place Array Modification
- Character Compression
- Frequency Counting

---

## Key Insight

Separate the responsibilities of the two pointers:

- **Read pointer** counts groups of identical characters.
- **Write pointer** overwrites the original array with the compressed result.

This allows compression without creating another array.

---

## Common Mistakes

- Using an extra array or `StringBuilder`.
- Forgetting to write multi-digit counts one digit at a time.
- Returning the original array length instead of the compressed length.
- Not updating the write pointer after every write.

---

## Revision Status

🟡 Solve Again

**Reason:**

- First problem using the **read/write pointer** technique.
- Introduces **in-place array compression**, a common interview pattern.
- Good problem to revisit before medium-level array/string questions.

- today i am working on my apptitude
- 
