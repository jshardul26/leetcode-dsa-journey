import java.util.*;

class Solution {
    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        // Count frequency of every character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find the first character whose frequency is 1
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}
