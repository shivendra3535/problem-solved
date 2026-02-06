class Solution {
    
    public void solveNQueens(char [][]board, int row, int n, List<List<String>> res, boolean []checkCol, boolean [] checkLeftDiag, boolean []checkRightDiag){
        if(row==n){
            List<String> temp= new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }

        for(int j=0; j<n; j++){
            int leftIndex=row+j;
            int rightIndex=(n-1)+(row-j);
            if(!checkCol[j] && !checkLeftDiag[leftIndex] && !checkRightDiag[rightIndex]){
                board[row][j]='Q';
                checkCol[j]=true;
                checkLeftDiag[leftIndex]=true;
                checkRightDiag[rightIndex]=true;
                solveNQueens(board,row+1,n,res,checkCol, checkLeftDiag, checkRightDiag);
                board[row][j]='.';
                checkCol[j]=false;
                checkLeftDiag[leftIndex]=false;
                checkRightDiag[rightIndex]=false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char board[][]= new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> res= new ArrayList<>();
        boolean checkCol[]= new boolean[n];
        boolean checkLeftDiag[]= new boolean[2*n-1];
        boolean checkRightDiag[]= new boolean[2*n-1];
        solveNQueens(board,0,n,res, checkCol, checkLeftDiag, checkRightDiag);
        return res;
    }
}