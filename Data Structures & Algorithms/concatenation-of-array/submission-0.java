class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] out = new int[nums.length*2];
        int i =0;
        int j=0;
        while (i<nums.length*2) {
            out[i] = nums[j];
            i++;j++;
            if(j == nums.length) j =0;
        }
        return out;
    }
}