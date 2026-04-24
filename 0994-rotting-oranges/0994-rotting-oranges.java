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
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]= new boolean[n][m];
        Queue<Pair> queue= new LinkedList<>();
        int cnt=-1;
        int fresh=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j));
                    vis[i][j]= true;
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                Pair node= queue.poll();
                int r=node.row;
                int c=node.col;
                for(int d[]: dir){
                    int nR=r+d[0];
                    int nC=c+d[1];
                    if(nR>=0 && nC>=0 && nR<n && nC<m && grid[nR][nC]==1 && !vis[nR][nC]){
                        queue.offer(new Pair(nR,nC));
                        vis[nR][nC]=true;
                        fresh--;
                    }
                }
            }
            cnt++;
        }
        if(fresh>0) return -1;
        return cnt;
    }
}