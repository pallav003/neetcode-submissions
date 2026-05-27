class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        subsets(nums,new ArrayList<>(), 0,output);
        return output;
        
    }

    public void subsets(int[] nums, 
    List<Integer> tempList, int index,
    List<List<Integer>> outputList) {
        outputList.add(new ArrayList<>(tempList));
        for (int i = index; i<nums.length;i++) {
            tempList.add(nums[i]);
            subsets(nums,tempList, i+1, outputList);
            tempList.remove(tempList.size()-1);
        }
    }

}
