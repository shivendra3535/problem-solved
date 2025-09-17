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
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        int dist[][]= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Triple> pq= new PriorityQueue<>((a,b)->a.distance-b.distance);
        dist[0][0]=1;
        pq.offer(new Triple(1,0,0));
        int dir[][]= {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        while(!pq.isEmpty()){
            Triple t=pq.poll();
            int distance=t.distance;
            int row=t.row;
            int col=t.col;
            if (row == m - 1 && col == n - 1) {
                return distance; // reached target
            }
            for(int d[]: dir){
                int newRow=row+d[0];
                int newCol=col+d[1];
                if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && grid[newRow][newCol]==0){
                    if(distance+1 < dist[newRow][newCol]){
                        dist[newRow][newCol]=distance+1;
                        pq.offer(new Triple(dist[newRow][newCol],newRow,newCol));
                    }
                }
            }
        }
       
        return -1;
    }
}