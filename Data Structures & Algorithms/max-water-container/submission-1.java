class Solution {
     public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxWater = 0;
        while (i < j) {
            maxWater = Math.max((j - i) * Math.min(heights[i], heights[j]), maxWater);
            if (heights[i] >= heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxWater;
    }
}
