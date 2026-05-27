class Solution {
    int[]cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        return Math.min(DFS(0,cost), DFS(1,cost));
    }
    public int DFS(int i, int[]cost) {
        if (i>=cost.length) return 0;
        if(cache[i]!= 0) return cache[i];
        cache[i] = cost[i] + Math.min(DFS(i+1,cost) , DFS(i+2,cost));
        return cache[i];
    }
}
