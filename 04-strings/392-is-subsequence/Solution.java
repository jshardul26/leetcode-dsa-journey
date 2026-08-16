class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {

            char ch1 = t.charAt(i);
            char ch2 = s.charAt(j);

            if (ch1 == ch2) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == m;
    }
}
