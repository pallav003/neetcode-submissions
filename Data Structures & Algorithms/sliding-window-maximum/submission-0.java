class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int [] outputArr = new int [nums.length - k +1];

    for(int i =0;i<nums.length;i++) {
        if (!deque.isEmpty() && deque.peekFirst() < i - k +1) {
            deque.pollFirst();
        }
        while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
        }
        deque.addLast(i);

        if(i >= k-1) {
            outputArr[i-k+1] = nums[deque.peekFirst()];
        }
    }
    return outputArr;
    }
}
