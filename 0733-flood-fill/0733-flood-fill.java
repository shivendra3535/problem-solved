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

        int prev=image[sr][sc];
        if(prev==color) return image;
        Queue<Pair> queue= new LinkedList<>();
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        queue.offer(new Pair(sr,sc));
        image[sr][sc]=color;
        while(!queue.isEmpty()){
            Pair node=queue.poll();
            int r=node.row;
            int c=node.col;
            for(int d[]: dir){
                int nR=r+d[0];
                int nC=c+d[1];
                if(nR>=0 && nC>=0 && nR<image.length && nC<image[0].length && image[nR][nC]==prev){
                    image[nR][nC]=color;
                    queue.offer(new Pair(nR,nC));
                }
            }
        }
        return image;
    }
}