class Solution {
    public int cherry(int grid[][], int row, int c1, int c2,int dp[][][]){
        if(c1<0 || c2<0 || c1>=grid[0].length || c2>=grid[0].length) return 0;
        if(row==grid.length-1){
            if(c1==c2) return dp[row][c1][c2]=grid[row][c1];
            else return dp[row][c1][c2]= grid[row][c1]+grid[row][c2];
        }
        if(dp[row][c1][c2]!=-1) return dp[row][c1][c2];
        int max=0;
        for(int x=-1; x<=1; x++){
            for(int y=-1; y<=1; y++){
                int ans=0;
                int nc1=c1+x;
                int nc2=c2+y;
                if(c1==c2) ans=grid[row][c1]+cherry(grid,row+1,nc1,nc2,dp);
                else ans=grid[row][c1]+grid[row][c2]+cherry(grid,row+1,nc1,nc2,dp);
                max=Math.max(ans,max);
            }
        }
        return dp[row][c1][c2]=max;
    }
    public int cherryPickup(int[][] grid) {
        int dp[][][]=new int[grid.length][grid[0].length][grid[0].length];
        for(int mat[][]: dp){
            for(int row[]: mat){
                Arrays.fill(row,-1);
            }
        }
        return cherry(grid,0,0,grid[0].length-1,dp); 
    }
}