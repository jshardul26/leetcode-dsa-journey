class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        // Try every possible substring length
        for (int len = 1; len <= n / 2; len++) {

            // Length must divide the total length
            if (n % len != 0) {
                continue;
            }

            // Candidate pattern
            String pattern = s.substring(0, len);

            StringBuilder sb = new StringBuilder();

            // Repeat the pattern
            int times = n / len;

            for (int i = 0; i < times; i++) {
                sb.append(pattern);
            }

            // Check if it matches the original string
            if (sb.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
