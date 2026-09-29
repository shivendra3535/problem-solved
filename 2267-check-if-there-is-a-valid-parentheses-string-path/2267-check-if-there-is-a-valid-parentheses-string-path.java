class Solution {
    public boolean recur(char [][] grid, int r, int c, int balance, int m, int n, Boolean dp[][][]){
        if(r<0 || c<0 || r>=m || c>=n) return false;

        if(grid[r][c]==')') balance++;

        else{
            balance--;
        }
        if(balance<0) return false;

        if(r==0 && c==0){
            return balance==0;
        }

        if(dp[r][c][balance]!=null) return dp[r][c][balance];
        boolean up=recur(grid,r-1,c,balance,m,n,dp);
        boolean left=recur(grid,r,c-1,balance,m,n,dp);
        return dp[r][c][balance]= up || left;
    }
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]!='(' || grid[m-1][n-1]!=')') return false;

        Boolean[][][] dp = new Boolean[m][n][m + n];
        return recur(grid,m-1,n-1,0,m,n,dp);
    }
}