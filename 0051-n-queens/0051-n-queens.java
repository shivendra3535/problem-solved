import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        boolean cols[]=new boolean[n];
        boolean leftDiagonal[]= new boolean[2*n-1];
        boolean rightDiagonal[]= new boolean[2*n-1];

        // Start backtracking
        backtrack(result, board, 0, n, cols, leftDiagonal, rightDiagonal);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row, int n, boolean cols[], boolean leftDiagonal[], boolean rightDiagonal[]){
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            result.add(temp);
            return;
        }

        for (int j = 0; j < n; j++) {
            int leftIndex= row+j;
            int rightIndex= n-1+row-j;
            if (!cols[j] && !leftDiagonal[leftIndex] && !rightDiagonal[rightIndex]){
                board[row][j] = 'Q';
                cols[j]=true;
                leftDiagonal[leftIndex]=true;
                rightDiagonal[rightIndex]=true;
                backtrack(result, board, row + 1, n, cols, leftDiagonal, rightDiagonal);
                board[row][j] = '.';
                cols[j]=false;
                leftDiagonal[leftIndex]=false;
                rightDiagonal[rightIndex]=false;
            }
        }
    }

}
