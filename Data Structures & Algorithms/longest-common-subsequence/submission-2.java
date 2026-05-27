class Solution {
    int [] [] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];
        for(int i =0; i< m;i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(m+" "+n);
       return dfs(text1,text2,m-1,n-1);
    }

    public int dfs(String a, String b, int m, int n) {
        if(m == -1 || n ==-1) {
            return 0;
        }
        if (dp[m][n]!=-1) {
            return dp[m][n];
        }
        if (a.charAt(m) == b.charAt(n)) {
            dp[m][n] = 1 + dfs(a,b,m-1,n-1);
            return dp[m][n];
        }
        dp[m][n] = Math.max(dfs(a,b,m-1,n), dfs(a,b,m,n-1));
        return dp[m][n];

    }
}
