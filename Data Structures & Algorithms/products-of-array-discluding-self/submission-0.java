class Solution {
   public int[] productExceptSelf(int[] nums) {
        int[] prefArr = new int[nums.length];
        int[] suffArr = new int[nums.length];
        prefArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefArr[i] = prefArr[i - 1] * nums[i - 1];
        }
        suffArr[nums.length-1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffArr[i] = suffArr[i + 1] * nums[i + 1];
        }
        int[] outputArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            outputArr[i] = prefArr[i] * suffArr[i];
        }
        return outputArr;
    }
}  
