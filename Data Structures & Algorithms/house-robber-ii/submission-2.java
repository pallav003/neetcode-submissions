class Solution {
    int []dp;
    public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];

    dp = new int[nums.length+1];
    Arrays.fill(dp, -1);
    int max1 = robHelper(nums,dp,0,nums.length-1);
    Arrays.fill(dp,-1);
    int max2 = robHelper(nums,dp,1, nums.length);
    return Math.max(max1, max2);
    }

    public int robHelper(int[] nums, int[]dp, int start, int end) {
        if(start >= end) {
            return 0;
        }
        if(dp[start]!= -1) return dp[start];

        dp[start]= Math.max(nums[start]+robHelper(nums,dp,start+2, end),
        robHelper(nums,dp,start+1,end));
        return dp[start];
        
    }
}
