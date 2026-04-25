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
        int ans[][]= new int[mat.length][mat[0].length];
        boolean vis[][]= new boolean[mat.length][mat[0].length];
        Queue<Pair> queue= new LinkedList<>();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    queue.offer(new Pair(i,j,0));
                }
            }
        }
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            Pair p= queue.poll();
            int r=p.row;
            int c=p.col;
            int s=p.step;
            ans[r][c]=s;
            for(int d[]: dir){
                int nR=r+d[0];
                int nC=c+d[1];
                if(nR>=0 && nC>=0 && nR<mat.length && nC<mat[0].length && !vis[nR][nC]){
                    vis[nR][nC]=true;
                    queue.offer(new Pair(nR,nC,s+1));
                }
            }
        }return ans;

    }
}