class Solution {
    public String reverseStr(String s, int k) {

        char[] ch = s.toCharArray();

        for (int start = 0; start < ch.length; start += 2 * k) {

            int left = start;
            int right = Math.min(start + k - 1, ch.length - 1);

            while (left < right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;

                left++;
                right--;
            }
        }

        return new String(ch);
    }
}
