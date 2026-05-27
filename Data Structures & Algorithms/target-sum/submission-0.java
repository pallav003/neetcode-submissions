class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      return  targetSumHelper(nums,target, 0, 0);
    }

    public int targetSumHelper(int[] nums, int target,
    int currentSum, int index) {
        if(currentSum == target && index == nums.length) return 1;
        if(index >= nums.length) return 0;
        return 
        targetSumHelper(nums,target, currentSum + nums[index], index + 1)+
        targetSumHelper(nums,target, currentSum - nums[index], index + 1);

    }

}
