class Solution {
    public int majorityElement(int[] nums) {
        int max = 0,out=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums) {
            map.merge(i,1,Integer::sum);
            if(map.get(i) > max) {
                max = map.get(i);
                out = i;
            }
            
        }   
        // System.out.println(map);
        return out;
    }
}