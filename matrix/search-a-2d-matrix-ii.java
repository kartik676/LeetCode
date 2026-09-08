class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
       

        int r = 0;
        int c = matrix[0].length - 1; // start at top-right

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            else if(matrix[r][c] > target) {
                c--; // move left
            } else {
                r++; // move down
            }
        }
        return false;
    }
}
