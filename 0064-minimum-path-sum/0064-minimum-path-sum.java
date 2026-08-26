class Solution {
    public int minPath(int grid[][], int m, int n, int dp[][]){
        if(m<0 || n<0) return (int) 1e9;;
        if(m==0 && n==0){
            dp[m][n]=grid[0][0];
            return dp[m][n];
        }
        if(dp[m][n]!=-1) return dp[m][n];
        int up=grid[m][n]+minPath(grid,m-1,n,dp);
        int left=grid[m][n]+minPath(grid,m,n-1,dp);
        dp[m][n]= Math.min(up,left);
        return dp[m][n];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return minPath(grid,grid.length-1, grid[0].length-1,dp);
    }
}