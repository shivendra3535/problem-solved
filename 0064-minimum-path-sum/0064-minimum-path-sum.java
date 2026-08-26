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
    public int tabulation(int grid[][], int m, int n){
        int dp[][]= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[0][0]=grid[0][0];
                    continue;
                }
                else{
                    int up=(int)1e9;
                    int left=(int)1e9;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int spaceOpt(int grid[][], int m, int n){
        int prevDp[]= new int[n];
        for(int i=0; i<m; i++){
            int tempDp[]= new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    tempDp[j]=grid[i][j];
                    continue;
                }
                else{
                    int up=(int)1e9;
                    int left=(int)1e9;
                    if(i>0) up=prevDp[j];
                    if(j>0) left=tempDp[j-1];
                    tempDp[j]=grid[i][j]+Math.min(up,left);
                }
            }
            prevDp=tempDp;
        }
        return prevDp[n-1];
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        /*int dp[][]= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return minPath(grid,grid.length-1, grid[0].length-1,dp); */
        //return tabulation(grid,m,n);
        return spaceOpt(grid,m,n);
    }
}