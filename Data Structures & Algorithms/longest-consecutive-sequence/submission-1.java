class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] + 1)) {
                int tempLength = 1;
                int j = 1;
                while (set.contains(nums[i] - j)) {
                    tempLength++;
                    j++;
                }
                maxLength = Math.max(tempLength, maxLength);
            }
        }
        return maxLength;
    }
}
