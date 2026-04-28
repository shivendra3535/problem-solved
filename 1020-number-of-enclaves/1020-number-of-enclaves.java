class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int [][]grid, int sr, int sc, boolean vis[][]){
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(sr,sc));
        vis[sr][sc]=true;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int r=p.row;
            int c=p.col;
            for(int d[]: dir){
                int nR=r+d[0];
                int nC=c+d[1];
                if(nR>=0 && nC>=0 && nR<grid.length && nC<grid[0].length && !vis[nR][nC] && grid[nR][nC]==1){
                    vis[nR][nC]=true;
                    queue.offer(new Pair(nR,nC));
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        boolean vis[][]= new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid[0].length; i++){
            if(grid[0][i]==1 && !vis[0][i]) bfs(grid,0,i,vis);
            if(grid[grid.length-1][i]==1 && !vis[grid.length-1][i]) bfs(grid,grid.length-1,i,vis);
        }
        for(int i=0; i<grid.length; i++){
            if(grid[i][0]==1 && !vis[i][0]) bfs(grid,i,0,vis);
            if(grid[i][grid[0].length-1]==1 && !vis[i][grid[0].length-1]) bfs(grid,i,grid[0].length-1,vis);
        }

        int cnt=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1 && !vis[i][j]) cnt++;
            }
        }
        return cnt;
    }
}