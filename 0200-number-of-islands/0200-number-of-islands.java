import java.util.*;

class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int row, int col, char[][] grid, boolean[][] vis) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        vis[row][col] = true;
        queue.offer(new Pair(row, col));

        int[][] dir = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
        };

        while (!queue.isEmpty()) {

            Pair node = queue.poll();

            int r = node.row;
            int c = node.col;

            for (int[] d : dir) {

                int nRow = r + d[0];
                int nCol = c + d[1];

                if (
                    nRow >= 0 &&
                    nRow < n &&
                    nCol >= 0 &&
                    nCol < m &&
                    grid[nRow][nCol] == '1' &&
                    !vis[nRow][nCol]
                ) {
                    vis[nRow][nCol] = true;
                    queue.offer(new Pair(nRow, nCol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !vis[i][j]) {
                    cnt++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return cnt;
    }
}