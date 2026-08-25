class Solution {
    public int uniquePath(int [][]obs, int m, int n, int dp[][]){
        if(m<0 || n<0 || obs[m][n]==1) return 0;
        if(m==0 && n==0) return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        int up=uniquePath(obs,m-1,n,dp);
        int left=uniquePath(obs,m,n-1,dp);
        dp[m][n]=up+left;
        return dp[m][n];
    }
    public int tabulation(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                
                if(i==0 && j==0){
                    dp[0][0]=1;
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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*int dp[][]= new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<obstacleGrid.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return uniquePath(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,dp); */
        return tabulation(obstacleGrid);
    }
}