class Solution {
    public void dfs(char[][] board,int sr,int sc,boolean vis[][]){
        int m=board.length;
        int n=board[0].length;
        vis[sr][sc]=true;
        int [][]dir={{0,-1},{0,1},{-1,0},{1,0}};
        for(int []d:dir){
            int newRow=sr+d[0];
            int newCol=sc+d[1];
            if(newRow>=0 && newCol>=0 && newRow<m &&newCol<n && board[newRow][newCol]=='O' && !vis[newRow][newCol]){
                dfs(board,newRow,newCol,vis);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]= new boolean[m][n];
        for(int i=0; i<n; i++)
        {
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(board,0,i,vis);
            }
            if(board[m-1][i]=='O' && !vis[m-1][i]){
                dfs(board,m-1,i,vis);
            }
        }
        for(int i=0; i<m; i++)
        {
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(board,i,0,vis);
            }
            if(board[i][n-1]=='O' && !vis[i][n-1]){
                dfs(board,i,n-1,vis);
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }
}