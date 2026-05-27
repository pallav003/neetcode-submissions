class Solution {
    public int climbStairs(int n) {

      return countways(0,n);  
    }

    public int countways(int i , int n){
        if (i>=n) return i==n?1:0;
        return countways(i+1,n) + countways(i+2,n);
    }
}
