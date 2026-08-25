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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]= new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i<obstacleGrid.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return uniquePath(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,dp);
    }
}