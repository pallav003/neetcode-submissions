class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
List<List<Integer>> op = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<nums.length;j++){
                if (j > i+1 && nums[j] == nums[j-1]) continue;

                int left = j+1, right = nums.length-1;

                while(left <right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        op.add(List.of(nums[i],nums[j],nums[left],nums[right]));

                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                    else if (sum > target) {
                        right--;
                    }           
                    else {
                        left++;
                    }     

            }
        }
       
    }
     return op;
}
}