class Solution {
    int [][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) sum+=i;
        dp = new int [nums.length ][2001];
        for (int[] row : dp) Arrays.fill(row , -1);
      return  targetSumHelper(nums,target, 0, 0);
    }

    public int targetSumHelper(int[] nums, int target,
    int currentSum, int index) {
        if(currentSum == target && index == nums.length) return 1;
        if(index >= nums.length) return 0;
        int sumIndex = currentSum + 1000;
        if (dp[index][sumIndex] != -1) return dp[index][sumIndex];
        dp [index] [sumIndex] = 
        targetSumHelper(nums,target, currentSum + nums[index], index + 1)+
        targetSumHelper(nums,target, currentSum - nums[index], index + 1);
        return dp[index][sumIndex];
    }

}
