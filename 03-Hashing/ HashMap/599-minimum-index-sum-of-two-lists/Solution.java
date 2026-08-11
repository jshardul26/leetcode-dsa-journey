import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();

        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {

            String restaurant = list2[i];

            if (map.containsKey(restaurant)) {

                int sum = map.get(restaurant) + i;

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(restaurant);

                } else if (sum == minSum) {
                    result.add(restaurant);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
