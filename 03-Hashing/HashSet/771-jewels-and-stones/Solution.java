import java.util.*;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        Set<Character> set = new HashSet<>();

        // Store all jewel characters
        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            set.add(ch);
        }

        int count = 0;

        // Check every stone
        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);

            if (set.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}
