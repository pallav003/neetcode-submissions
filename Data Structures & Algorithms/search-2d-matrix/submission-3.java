class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
         int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int targetRow = Integer.MIN_VALUE;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                targetRow = mid;
                break;
            } else if (target > matrix[mid][n - 1]) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        if (targetRow == Integer.MIN_VALUE) {
            return false;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }
}
