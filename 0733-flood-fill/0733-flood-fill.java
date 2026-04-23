class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        boolean vis[][] = new boolean[n][m];
        vis[sr][sc]=true;
        int original=image[sr][sc];
        image[sr][sc]=color;
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(sr,sc));
        int dir[][]={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!q.isEmpty()){
            Pair node=q.poll();
            int r=node.row;
            int c=node.col;
            for(int d[]: dir){
                int nR=r+d[0];
                int nC=c+d[1];
                if(nR>=0 && nC>=0 && nR<n && nC<m && image[nR][nC]==original && !vis[nR][nC]){
                    vis[nR][nC]=true;
                    image[nR][nC]=color;
                    q.offer(new Pair(nR,nC));
                }
            }
        }
        return image;
    }
}