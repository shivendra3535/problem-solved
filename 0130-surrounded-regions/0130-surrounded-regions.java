class Solution {
    public void dfs(char [][] board, int row, int col, boolean vis[][]){
        vis[row][col]=true;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int d[]: dir){
            int nR=row+d[0];
            int nC=col+d[1];
            if(nR>=0 && nC>=0 && nR<board.length && nC<board[0].length && board[nR][nC]=='O' && !vis[nR][nC]){
                dfs(board,nR,nC,vis);
            }
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]= new boolean[n][m];
        for(int i=0; i<m; i++){
            if(board[0][i]=='O') dfs(board,0,i,vis);
            if(board[n-1][i]=='O') dfs(board,n-1,i,vis);
        }
        for(int i=0; i<n; i++){
            if(board[i][0]=='O') dfs(board,i,0,vis);
            if(board[i][m-1]=='O') dfs(board,i,m-1,vis);
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
}