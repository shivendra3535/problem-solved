class Node{
    int row;
    int col;
    int step;
    Node(int row,int col,int step){
        this.row=row;
        this.col=col;
        this.step=step;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean vis[][]=new boolean[m][n];
        int dist[][]= new int[m][n];
        Queue<Node> queue= new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                   queue.offer(new Node(i,j,0));
                   vis[i][j]=true;
                }
            }
        }

        int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
        while(!queue.isEmpty()){
            Node node= queue.poll();
            int r=node.row;
            int c=node.col;
            int steps=node.step;
            dist[r][c]=steps;
            for(int []d:dir){
                int newRow=r+d[0];
                int newCol=c+d[1];
                if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && !vis[newRow][newCol]){
                    vis[newRow][newCol]=true;
                    queue.offer(new Node(newRow,newCol,steps+1));
                }
            }
        }
        return dist;
    }
}