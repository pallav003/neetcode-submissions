class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        return dfs(nums,0);
    }

    public int dfs(int[] nums, int index) {
        if(index >= nums.length) {
            return 0;
        }
        if(dp[index] != Integer.MIN_VALUE) {
            return dp[index];
        }
        dp[index] = Math.max(nums[index]+dfs(nums,index+2), dfs(nums,index+1));
        return dp[index];
    }
}
