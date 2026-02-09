class Solution {
    public boolean validNum(char [][]board, int row, int col,char c){
        for(int i=0; i<board.length; i++){
            if(board[row][i]==c) return false;
            if(board[i][col]==c) return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
        }
        return true;
    }
    public boolean solver(char[][] board) {
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board.length; col++){
                if(board[row][col]=='.'){
                    for(char c='1'; c<='9'; c++){
                        if(validNum(board,row,col,c)){
                            board[row][col]=c;
                            if(solver(board)) return true;
                            board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board){
        boolean b=solver(board);
    }

}