class Solution {
    public long dfs(int grid[][], int row, int col, boolean vis[][]){
        vis[row][col]=true;
        int dir[][]={{1,0},{-1,0},{0,-1},{0,1}};
        long sum=grid[row][col];
        for(int d[]: dir){
            int nr=row+d[0];
            int nc=col+d[1];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]>0){
                sum+=dfs(grid,nr,nc,vis);
            }
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]= new boolean[m][n];
        int cnt=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]>0){
                    long sum=dfs(grid,i,j,vis);
                    if(sum%k==0) cnt++;
                }
            }
        }

        return cnt;
    }
}