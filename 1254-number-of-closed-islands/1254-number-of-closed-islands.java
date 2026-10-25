
class Solution {
    public void dfs(int[][] grid, int row, int col, boolean[][] vis) {
        vis[row][col] = true;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] d : dir) {
            int nr = row + d[0];
            int nc = col + d[1];

            if (nr >= 0 && nc >= 0 &&
                nr < grid.length && nc < grid[0].length &&
                !vis[nr][nc] && grid[nr][nc] == 0) {

                dfs(grid, nr, nc, vis);
            }
        }
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0 && !vis[i][0]) {
                dfs(grid, i, 0, vis);
            }

            if (grid[i][n - 1] == 0 && !vis[i][n - 1]) {
                dfs(grid, i, n - 1, vis);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0 && !vis[0][j]) {
                dfs(grid, 0, j, vis);
            }

            if (grid[m - 1][j] == 0 && !vis[m - 1][j]) {
                dfs(grid, m - 1, j, vis);
            }
        }

        int cnt = 0;

        
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
