class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;

        int minLen = nums.length+1;

        for(;right<nums.length;right++){
            sum+=nums[right];
            while(sum >= target) {
                minLen = Math.min(minLen, right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return minLen == nums.length+1 ? 0 : minLen;
        
    }
}