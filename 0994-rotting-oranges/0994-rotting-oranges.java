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
        boolean vis[][]= new boolean[grid.length][grid[0].length];
        int freshCnt=0;
        int min=-1;
        Queue<Pair> queue= new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    vis[i][j]=true;
                    queue.offer(new Pair(i,j));
                }
                else if(grid[i][j]==1) freshCnt++;
            }
        }
        if(freshCnt==0) return 0;
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            min++;
            int size=queue.size();
            for(int i=0; i<size; i++){
                Pair p= queue.poll();
                int r=p.row;
                int c=p.col;
                for(int d[]: dir){
                    int nR=r+d[0];
                    int nC=c+d[1];
                    if(nR>=0 && nC>=0 && nR<grid.length && nC<grid[0].length && !vis[nR][nC] && grid[nR][nC]==1){
                       vis[nR][nC]=true;
                       freshCnt--;
                       queue.offer(new Pair(nR,nC));
                    }
                }
            }
        }
        if(freshCnt!=0) return -1;
        return min;
    }
}