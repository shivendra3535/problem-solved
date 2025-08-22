class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public void bfs(int ro,int co, boolean vis[][],char grid[][]){
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(ro,co));
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            int r=p.row;
            int c=p.col;
            //horizotal left neighbour
            if(c > 0 && grid[r][c-1]=='1' && !vis[r][c-1]){
                vis[r][c-1]=true;
                queue.offer(new Pair(r,c-1));
            }
            //horizontal right neighbour
            if(c<grid[0].length -1 && grid[r][c+1]=='1' && !vis[r][c+1]){
                vis[r][c+1]=true;
                queue.offer(new Pair(r,c+1));
            }
            //verical above neighbour
            if(r>0 && grid[r-1][c]=='1' && !vis[r-1][c]){
                vis[r-1][c]=true;
                queue.offer(new Pair(r-1,c));
            }

            //vertical below neighbour
            if(r< grid.length -1 && grid[r+1][c]=='1' && !vis[r+1][c]){
                vis[r+1][c]=true;
                queue.offer(new Pair(r+1,c));
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]= new boolean[m][n];
        int cnt=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                   cnt++;
                   bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }
}