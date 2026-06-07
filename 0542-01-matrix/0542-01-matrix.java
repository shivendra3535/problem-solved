class Solution {
    class Pair{
        int row;
        int col;
        int step;
        Pair(int row, int col, int step){
            this.row=row;
            this.col=col;
            this.step=step;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> queue= new LinkedList<>();
        boolean vis[][]= new boolean[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    queue.offer(new Pair(i,j,0));
                }
            }
        }
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            int r=p.row;
            int c=p.col;
            int steps=p.step;
            for(int d[]: dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<mat.length && nr>=0 && nc<mat[0].length && nc>=0 && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    mat[nr][nc]=steps+1;
                    queue.offer(new Pair(nr,nc,steps+1));
                }
            }
        }
        return mat;
    }
}