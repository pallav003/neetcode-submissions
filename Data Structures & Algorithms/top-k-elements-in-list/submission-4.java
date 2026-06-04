class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(entry.getKey());
        }
        int [] out = new int[k];
        int index = 0;
        for(int i = buckets.length-1;i>=0;i--) {
            if (buckets[i]!=null) {
                for(int num : buckets[i]) {
                    out[index++] = num;

                    if(index == k) {
                        return out;
                    }
                }
            }
        }
        return out;
    }
}
