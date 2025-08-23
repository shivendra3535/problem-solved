class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public void bfs(int[][] image,int sr,int sc,int color,int prev,boolean vis[][]){
        int m=image.length;
        int n=image[0].length;
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(sr,sc));
        vis[sr][sc]=true;
        image[sr][sc]=color;
        while(!queue.isEmpty()){
            Pair p= queue.poll();
            int r=p.row;
            int c=p.col;

            if(c>0 && image[r][c-1]==prev && !vis[r][c-1]){
                vis[r][c-1]=true;
                image[r][c-1]=color;
                queue.offer(new Pair(r,c-1));
            }

            if(c<n-1 && image[r][c+1]==prev && !vis[r][c+1]){
                vis[r][c+1]=true;
                image[r][c+1]=color;
                queue.offer(new Pair(r,c+1));
            }

            if(r>0 && image[r-1][c]==prev && !vis[r-1][c]){
                vis[r-1][c]=true;
                image[r-1][c]=color;
                queue.offer(new Pair(r-1,c));
            }
            
            if(r<m-1 && image[r+1][c]==prev && !vis[r+1][c]){
                vis[r+1][c]=true;
                image[r+1][c]=color;
                queue.offer(new Pair(r+1,c));
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        boolean vis[][]=new boolean[m][n];
        int prev=image[sr][sc];
        bfs(image,sr,sc,color,prev,vis);
        return image;
    }
}