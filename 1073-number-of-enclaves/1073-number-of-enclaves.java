class Solution {
    public void dfs(int [][]grid,int sr,int sc,boolean vis[][]){
        int m=grid.length;
        int n=grid[0].length;
        vis[sr][sc]=true;
        int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
        for(int []d:dir){
            int nR=sr+d[0];
            int nC=sc+d[1];
            if(nR>=0 && nC>=0 && nR<m && nC<n && grid[nR][nC]==1 && !vis[nR][nC]){
                dfs(grid,nR,nC,vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]= new boolean[m][n];
        // Traverse the first and last row
        for (int i = 0; i < n; i++) {
           if (grid[0][i] == 1 && !vis[0][i]) {
             dfs(grid, 0, i, vis);
          }
          if (grid[m - 1][i] == 1 && !vis[m - 1][i]) {
             dfs(grid, m - 1, i, vis);
          }
       }

        // Traverse the first and last column
        for (int i = 0; i < m; i++) {
            if(grid[i][0] == 1 && !vis[i][0]) {
                dfs(grid, i, 0, vis);
                }
            if(grid[i][n - 1] == 1 && !vis[i][n - 1]) {
                dfs(grid, i, n - 1, vis);
                }
        }

        int cnt=0;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}