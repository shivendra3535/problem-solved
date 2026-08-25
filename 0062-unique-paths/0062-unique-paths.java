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
    public int tabulation(int m, int n){
        int dp[][]= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                else{
                    int up=0;
                    int left=0;

                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        /*int dp[][]= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return uniquePaths2(m-1,n-1,dp); */

        return tabulation(m,n);
    }
}