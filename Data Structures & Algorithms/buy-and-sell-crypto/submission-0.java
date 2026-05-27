class Solution {
    public int maxProfit(int[] prices) {
       int temp = prices[0];
       int output = 0;
       for(int i = 1; i<prices.length;i++) {
        if (prices[i] - temp >0  ) {
            output = Math.max(output, prices[i]-temp);
        }
        else {
            temp = prices[i];
        }
       }
       return output;   
    }
}
