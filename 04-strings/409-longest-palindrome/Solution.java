class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        int count = 0;
        boolean hasOdd = false;

        for (int i = 0; i < freq.length; i++) {

            if (freq[i] % 2 == 0) {
                count += freq[i];
            } else {
                count += freq[i] - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            count++;
        }

        return count;
    }
}
