class Solution {
    class Tup{
        int row;
        int col;
        int effort;
        Tup(int row, int col, int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int dist[][]= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        PriorityQueue<Tup> pq= new PriorityQueue<>((a,b)->a.effort-b.effort);
        pq.offer(new Tup(0,0,0));
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            Tup p=pq.poll();
            int r=p.row;
            int c=p.col;
            int ef=p.effort;
            for(int d[]: dir){
                int nr=d[0]+r;
                int nc=d[1]+c;
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int newEffort=Math.max(ef,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(newEffort<dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.offer(new Tup(nr,nc,newEffort));
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}