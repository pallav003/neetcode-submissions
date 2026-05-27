class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationHelper(0, target, nums, list, new ArrayList<>());
        return list;
    }
    public void combinationHelper(int index, int target, int [] nums,
    List<List<Integer>> list, List<Integer> currentList) {
        if(target == 0) {
            list.add(new ArrayList<>(currentList));
            return;
        }
        if(target < 0 || index >= nums.length) {
            return;
        }
        
            currentList.add(nums[index]);
            combinationHelper(index, target - nums[index], nums,list, currentList);
            currentList.remove(currentList.size()-1);
            combinationHelper(index+1, target, nums, list, currentList);
        
    }

}
