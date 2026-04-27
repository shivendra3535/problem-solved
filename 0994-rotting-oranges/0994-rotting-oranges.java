class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<Pair> queue= new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int cnt=-1;
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size=queue.size();
            cnt++;
            for(int i=0; i<size; i++){
                Pair p=queue.poll();
                int r= p.row;
                int c= p.col;
                for(int d[]: dir){
                    int nR= r+d[0];
                    int nC= c+d[1];
                    if(nR>=0 && nC>=0 && nR<grid.length && nC<grid[0].length && grid[nR][nC]==1){
                        grid[nR][nC]=2;
                        fresh--;
                        queue.offer(new Pair(nR,nC));
                    }
                }
            }
        }
        if(fresh>0) return -1;
        return cnt;
    }
}