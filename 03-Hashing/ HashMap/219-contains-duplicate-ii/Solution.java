import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {

            if (map.containsKey(nums[j])) {

                int i = map.get(nums[j]);

                if (j - i <= k) {
                    return true;
                }
            }

            map.put(nums[j], j);
        }

        return false;
    }
}
