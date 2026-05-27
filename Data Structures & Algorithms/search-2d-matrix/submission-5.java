class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
         int maxLength = matrix.length;
         int columnLength = matrix[0].length;
         int low = 0, high = maxLength-1;
         int row = -1;
         while(low <= high) {
            int mid = low + ((high - low) / 2);
            if (matrix[mid][0] <= target &&  matrix[mid][columnLength-1] >= target) {
                row = mid;
                break;
            }
            else if (matrix[mid][columnLength-1] < target){
                low = mid+1;
            }
            else {
                high = mid -1;
            }
         }
         if (row == -1) {
            return false;
         }

         low = 0; high = columnLength-1;
         while(low <= high) {
            int mid = low + ((high - low) / 2);
            if (matrix[row][mid] == target) {
                return true;
            }
            else if (target < matrix[row][mid]){
                high = mid -1;
            }
            else {
                low = mid+1;
            }
         }
         return false;
    }
}
