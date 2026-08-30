class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }

    @SuppressWarnings("all")
    private static boolean solve(char[][] board) {

        var set = new HashSet<Character>();

        // Check all rows
        for (var row = 0; row < 9; row++) {
            for (var item = 0; item < 9; item++) {
                if (!Objects.equals(board[row][item], '.')) {
                    if (!set.add(board[row][item])) return false;
                }
            }

            set.clear();
        }

        // Check all cols
        for (var col = 0; col < 9; col++) {
            for (var item = 0; item < 9; item++) {
                if (!Objects.equals(board[item][col], '.')) {
                    if (!set.add(board[item][col])) return false;
                }
            }

            set.clear();
        }

        // 3x3 boxes
        for (var boxRow = 0; boxRow < 3; boxRow++) {
            for (var boxCol = 0; boxCol < 3; boxCol++) {

                var startRow = boxRow * 3;
                var startCol = boxCol * 3;

                for (var row = startRow; row < startRow + 3; row++) {
                    for (var col = startCol; col < startCol + 3; col++) {

                        if (!Objects.equals(board[row][col], '.')) {
                            if (!set.add(board[row][col])) return false;
                        }
                    }
                }

                set.clear();
            }
        }

        return true;
    }
}
