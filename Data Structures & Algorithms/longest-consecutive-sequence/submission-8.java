class Solution {
    public int longestConsecutive(int[] nums) {
     Set<Integer> set = new HashSet<>();
     for(int num : nums) {set.add(num);};
     int maxCount = 0;
     for(int num : nums) {
        int tempcount = 0;
        if(!set.contains(num+1)) {
            while(set.contains(num)) {
                num = num -1;
                tempcount++;
            }
           maxCount = Math.max(tempcount,maxCount);
        }
     }
     return maxCount;

    }
}
