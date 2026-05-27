class Solution {
     public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Determine if left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target lies in the left half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;  // Move left
                } else {
                    left = mid + 1;   // Move right
                }
            }
            // Right half is sorted
            else {
                // Target lies in the right half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;   // Move right
                } else {
                    right = mid - 1;  // Move left
                }
            }
        }
        return -1;
    }
}
