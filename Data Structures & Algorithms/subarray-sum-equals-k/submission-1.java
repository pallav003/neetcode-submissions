class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,1);
        int count =0;
        int sum = 0;
        for(int right = 0;right<nums.length;right++) {
            sum+=nums[right];
            count += prefixMap.getOrDefault(sum - k, 0);
            prefixMap.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}