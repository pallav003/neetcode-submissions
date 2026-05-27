class Solution {
    public int maxArea(int[] heights) {
     int i = 0, j = heights.length - 1;
     int max = 0;
     while(i < j) {
        max = Math.max(Math.min(heights[i], heights[j]) * (j - i), max);
        System.out.println(max +" "+ i+ " "+j);
        if(heights[i] > heights[j]) {
            j--;
        }
        else {
            i++;
        }
     }
     return max;

    }
}
