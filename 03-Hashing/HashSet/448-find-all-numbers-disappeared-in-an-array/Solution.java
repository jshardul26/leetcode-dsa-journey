import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        // Store all numbers from the array
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Check which numbers from 1 to n are missing
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}
