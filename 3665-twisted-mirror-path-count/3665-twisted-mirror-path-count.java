
import java.util.*;

class Solution {
    int MOD = 1_000_000_007;

    public int recur(int[][] grid, int i, int j,
                     int previousMove, int[][][] dp) {

        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        if (dp[i][j][previousMove] != -1) {
            return dp[i][j][previousMove];
        }

        int ans = 0;

        if (grid[i][j] == 0) {

            int right = recur(grid, i, j + 1, 1, dp);
            int down = recur(grid, i + 1, j, 2, dp);

            ans = (right + down) % MOD;

        } else {

            if (previousMove == 1) {
                ans = recur(grid, i + 1, j, 2, dp);
            } else {
                ans = recur(grid, i, j + 1, 1, dp);
            }
        }

        return dp[i][j][previousMove] = ans;
    }

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][3];

        for (int[][] row : dp) {
            for (int[] cell : row) {
                Arrays.fill(cell, -1);
            }
        }

        return recur(grid, 0, 0, 0, dp);
    }
}
