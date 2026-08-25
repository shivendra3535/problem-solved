class Solution {
    public int uniquePaths2(int m, int n, int dp[][]) {
        if (m < 0 || n < 0) return 0;
        if(m==0 && n==0){
            dp[m][n]=1;
            return dp[m][n];
        }
        if(dp[m][n]!=-1) return dp[m][n];
        int left=uniquePaths2(m,n-1,dp);
        int up=uniquePaths2(m-1,n,dp);
        dp[m][n]=left+up;
        return dp[m][n];
    }
    public int uniquePaths(int m, int n) {
        int dp[][]= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return uniquePaths2(m-1,n-1,dp);
    }
}