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
        for (int i : nums) {
            if (!set.contains(i+1)) {
                int tempLength = 1;
                while (set.contains(i-1)) {
                    tempLength++;
                    i--;
                }
                maxLength = Math.max(tempLength, maxLength);
            }
        }
        return maxLength;
    }
}
