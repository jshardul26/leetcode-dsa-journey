import java.util.*;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {

            // If we have already seen this number,
            // we are stuck in a cycle.
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);

            int sum = 0;

            // Calculate sum of squares of digits
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }
}
