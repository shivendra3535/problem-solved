class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(char [][]grid, int row, int col, boolean vis[][]){
        Queue<Pair> queue= new LinkedList<>();
        vis[row][col]=true;
        queue.offer(new Pair(row, col));
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            int r=p.row;
            int c=p.col;
            for(int d[]: dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<grid.length && nr>=0 && nc<grid[0].length && nc>=0 && grid[nr][nc]=='1' && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    queue.offer(new Pair(nr,nc));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int cnt=0;
        boolean vis[][]= new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    cnt++;
                    bfs(grid,i,j,vis);
                }
            }
        }
        return cnt;
    }
}