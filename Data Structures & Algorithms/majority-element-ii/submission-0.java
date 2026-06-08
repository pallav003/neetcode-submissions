class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> out = new ArrayList<>();
        for(int key : map.keySet()) {
            if (map.get(key) > nums.length/3) {
                out.add(key);
            }
        }
        return out;
    }
}