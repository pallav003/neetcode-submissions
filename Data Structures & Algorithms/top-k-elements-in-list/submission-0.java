class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i,0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets [freq] == null) {
                buckets [freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && list.size()<k ; i--) {
            if (buckets[i] != null) {
                list.addAll(buckets[i]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
