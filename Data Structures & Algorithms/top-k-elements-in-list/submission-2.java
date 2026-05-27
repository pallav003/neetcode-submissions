class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     Map<Integer, Integer> map = new HashMap<>();
     for(int num : nums)
        map.put(num,map.getOrDefault(num,0)+1);
    
     List<Integer>[] output = new List[nums.length+1];
     for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
        if(output[entry.getValue()] == null) {
            output[entry.getValue()] = new ArrayList<>();
        }
        output[entry.getValue()].add(entry.getKey());
     }
     List<Integer> outputList = new ArrayList<>();
     for(int i = output.length - 1; i>=0 && outputList.size()<k;i--) {
        if(output[i] != null)
            outputList.addAll(output[i]);
     }
     System.out.println(outputList);
     return outputList.stream().mapToInt(i -> i).limit(k).toArray();      
    }
}
