class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int [] out = new int[nums.length - k +1];

        int left = 0, right = 0;
        while(right< nums.length) {
            while(!dq.isEmpty() && nums[right] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(right);
            if (!dq.isEmpty() && dq.peekFirst() < left) {
                dq.removeFirst();
            }
            
            if (right - left + 1 == k) {
                out[left] = nums[dq.peekFirst()];
                left++;
            }
            right++;

        }


        return out;
    }
}
