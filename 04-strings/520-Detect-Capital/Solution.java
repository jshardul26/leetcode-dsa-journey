class Solution {
    public boolean detectCapitalUse(String word) {

        int upperCount = 0;

        // Count uppercase letters
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCount++;
            }
        }

        // Case 1: All uppercase
        if (upperCount == word.length()) {
            return true;
        }

        // Case 2: All lowercase
        if (upperCount == 0) {
            return true;
        }

        // Case 3: Only first letter uppercase
        if (upperCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}
