class Solution {
    int [][] memo;
    public int uniquePaths(int m, int n) {
     memo = new int[m][n];
        for(int i = 0; i< m;i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0,0,m,n);
    }

    public int dfs(int row,int col, int m ,int n) {
        if(row >=m || col >=n) {
            return 0;
        }
        if(memo[row][col]!=-1) {
            return memo[row][col];
        }
        if(row == m-1 && col == n-1) {
            return 1;
        }
        memo[row][col]= dfs(row+1,col,m,n) + dfs(row,col+1,m,n);
        return memo[row][col];
    }
}
