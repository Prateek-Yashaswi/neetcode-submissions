class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return solve(matrix, target);
    }

    private static boolean solve(int[][] matrix, int target) {
        var rows = matrix.length;
        var cols = matrix[0].length;
        var left = 0;
        var right = rows * cols - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2;
            var posRow = mid / cols;
            var posCol = mid % cols;
            System.out.println("(" + posRow + "," + posCol + ") Element = " + matrix[posRow][posCol]);

            if (matrix[posRow][posCol] == target) {
                return true;
            } else if (matrix[posRow][posCol] < target) {
                left = mid + 1;
            } else {
                right =  mid - 1;
            }
        }

        return false;
    }
}
