import java.util.*;

class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of every number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;

        // Check every number with its consecutive number
        for (int key : map.keySet()) {

            if (map.containsKey(key + 1)) {

                int count = map.get(key) + map.get(key + 1);

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
