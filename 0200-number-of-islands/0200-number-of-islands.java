class Solution {
    public void dfs(char [][]grid, boolean vis[][], int r, int c){
        vis[r][c]=true;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int d[]: dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]=='1'){
                dfs(grid,vis,nr,nc);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        boolean vis[][]= new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid,vis,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}