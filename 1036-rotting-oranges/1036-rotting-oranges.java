class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<Pair> queue= new LinkedList<>();
        //loading all the rotten ones in queue for bfs & counting fresh ones to track them
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0)return 0;
        int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
        int min=-1;
        //MultiSource BFS 
        while(!queue.isEmpty()){
            int size=queue.size();
            min++; //each level takes 1 min
            for(int i=0; i<size; i++){
            Pair p= queue.poll();
            int r=p.row;
            int c=p.col;
            for(int d[]:dir){
                int newRow=r+d[0];
                int newCol=c+d[1];
                if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && grid[newRow][newCol]==1){
                    grid[newRow][newCol]=2;
                    fresh--;
                    queue.offer(new Pair(newRow,newCol));
                }
            }
        }
         }

        if(fresh>0)return -1;
        return min;
     }
}