class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        comboSum(candidates,target,0, output, new ArrayList<>());
        return output;
    }

    public void comboSum(int[] candidates, int target,int index, List<List<Integer>> output,
    List<Integer> tempList) {
        if (index > candidates.length || target < 0) {
            return;
        }
        if(target == 0) {
        output.add(new ArrayList<>(tempList));
        return;
        }

        for(int i = index; i<candidates.length;i++){
              if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            comboSum(candidates, target - candidates[i], i+1,output,tempList);
            tempList.remove(tempList.size()-1);
        }        
    }
}
