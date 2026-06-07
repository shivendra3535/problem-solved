class Solution {
    public void dfs(int[][] grid, boolean vis[][], int row, int col){
        vis[row][col]=true;
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        for(int d[]: dir){
                int nr=row+d[0];
                int nc=col+d[1];
                if(nr<grid.length && nr>=0 && nc<grid[0].length && nc>=0 && !vis[nr][nc] && grid[nr][nc] == 1){
                    dfs(grid,vis,nr,nc);
                }
        }
    }
    public int numEnclaves(int[][] grid) {
        boolean vis[][]= new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid[0].length; i++){
            if(grid[0][i]==1 && !vis[0][i]){
                dfs(grid,vis,0,i);
            }

            if(grid[grid.length-1][i]==1 && !vis[grid.length-1][i]){
                dfs(grid,vis,grid.length-1,i);
            }
        }
        for(int i=0; i<grid.length; i++){
            if(grid[i][0]==1 && !vis[i][0]){
                dfs(grid,vis,i,0);
            }

            if(grid[i][grid[0].length-1]==1 && !vis[i][grid[0].length-1]){
                dfs(grid,vis,i,grid[0].length-1);
            }
        }
        int cnt=0;
        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                if(!vis[i][j] && grid[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
}