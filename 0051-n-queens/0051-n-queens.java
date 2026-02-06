class Solution {
    public boolean isSafe(char [][]board, int row, int col){
        for(int i=0; i<board.length; i++){
            if(board[row][i]=='Q') return false;
        }
        for(int i=0; i<board.length; i++){
            if(board[i][col]=='Q') return false;
        }
        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row,j=col; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    public void solveNQueens(char [][]board, int row, int n, List<List<String>> res){
        if(row==n){
            List<String> temp= new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for(int j=0; j<n; j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                solveNQueens(board,row+1,n,res);
                board[row][j]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][]= new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> res= new ArrayList<>();
        solveNQueens(board,0,n,res);
        return res;
    }
}