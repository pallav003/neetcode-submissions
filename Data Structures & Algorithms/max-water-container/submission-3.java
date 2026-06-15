class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = -1;
        while(left < right) {
            maxArea = Math.max(Math.min(heights[left],heights[right]) * (right-left), maxArea);
            if(heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}
