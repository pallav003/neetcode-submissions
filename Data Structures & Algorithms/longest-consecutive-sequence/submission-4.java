class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int maxLength = 1;
        for(int i : nums) {
            int temp = i;
            int tempMax = 0;
            if(!set.contains(temp+1)) {
            while(set.contains(temp)) {
                temp--;
                tempMax++;
            }
            }
            maxLength = Math.max(tempMax, maxLength);
        }
        return maxLength;
    }
}
