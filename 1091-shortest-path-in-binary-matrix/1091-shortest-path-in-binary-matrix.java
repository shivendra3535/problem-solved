class Solution {
    class Triple{
        int distance;
        int row;
        int col;
        Triple(int distance, int row, int col){
            this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int dist[][]= new int[n][n];
        PriorityQueue<Triple> pq= new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.offer(new Triple(1,0,0));
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=1;
        int dir[][]={{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
        while(!pq.isEmpty()){
            Triple top=pq.poll();
            int distance=top.distance;
            int row=top.row;
            int col=top.col;
            if(row==n-1 && col==n-1) return distance;
            for(int d[]: dir){
                int nR=row+d[0];
                int nC=col+d[1];
                if(nR>=0 && nC>=0 && nR<n && nC<n && grid[nR][nC]==0){
                    if(distance+1<dist[nR][nC]){
                        dist[nR][nC]=distance+1;
                        pq.offer(new Triple(dist[nR][nC],nR,nC));
                    }
                }
            }
        }
        return -1;
    }
}