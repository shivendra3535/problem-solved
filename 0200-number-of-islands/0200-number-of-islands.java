class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(char [][] grid, boolean vis[][], int row, int col){
        vis[row][col]=true;
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(row,col));
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            Pair p= queue.poll();
            int r=p.row;
            int c=p.col;
            for(int d[]: dir){
                int nR=r+d[0];
                int nC=c+d[1];
                if(nR>=0 && nC>=0 && nR<grid.length && nC<grid[0].length && !vis[nR][nC] && grid[nR][nC]=='1'){
                    vis[nR][nC]=true;
                    queue.offer(new Pair(nR,nC));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int cnt=0;
        boolean vis[][]= new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    cnt++;
                    bfs(grid,vis,i,j);
                }
            }
        }
        return cnt;
    }
}