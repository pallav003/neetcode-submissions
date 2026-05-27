class Solution {
        int[] cache;

    public int climbStairs(int n) {
        cache = new int[n];
      return countways(0,n);  
    }

    public int countways(int i , int n){
        if (i>=n) return i==n?1:0;
     if (cache[i] != 0) return cache[i];

        return cache[i] =countways(i+1,n) + countways(i+2,n);
    }
}
