import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char num = board[row][col];

                if (num == '.') {
                    continue;
                }

                String rowKey = "R" + row + num;
                String colKey = "C" + col + num;
                String boxKey = "B" + (row / 3) + (col / 3) + num;

                if (set.contains(rowKey) ||
                    set.contains(colKey) ||
                    set.contains(boxKey)) {

                    return false;
                }

                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }

        return true;
    }
}
