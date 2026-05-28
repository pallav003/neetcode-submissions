class Solution {
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        for(int i = 0; i <nums.length;i++) {
            if (nums[i] == val) {
                nums[i] = 51;
                count--;
            }
        } 
        Arrays.sort(nums);
        return count;
    }
}