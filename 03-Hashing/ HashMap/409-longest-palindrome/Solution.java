import java.util.*;

class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of every character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        boolean hasOdd = false;

        // Build the longest palindrome
        for (char key : map.keySet()) {

            if (map.get(key) % 2 == 0) {
                count += map.get(key);
            } else {
                hasOdd = true;
                count += map.get(key) - 1;
            }
        }

        // One odd character can be placed in the center
        if (hasOdd) {
            count++;
        }

        return count;
    }
}
