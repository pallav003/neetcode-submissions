class Solution {
    boolean [] pick;
    public List<List<Integer>> permute(int[] nums) {
        pick = new boolean[nums.length];
        List<List<Integer>> output = new ArrayList<>();
        dfs(output, nums, 0 , new ArrayList<>());
        return output;
    }
    
    public void dfs(List<List<Integer>> output, int[] nums,
    int idx, List<Integer> tempList) {
        if(idx > nums.length) {
            return;
        }
        if(tempList.size() == nums.length) {
            output.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length;i++) {
            if (pick[i]) {
                continue;
            }
            pick[i] = true;
            tempList.add(nums[i]);
            dfs(output, nums, idx+1,tempList);
            tempList.remove(tempList.size()-1);
            pick[i] = false;
        }
    }
}
