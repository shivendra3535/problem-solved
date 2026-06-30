class Solution {
    class Tripple{
        int row;
        int col;
        int efforts;
        Tripple(int row, int col, int efforts){
            this.row=row;
            this.col=col;
            this.efforts=efforts;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int dist[][]=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        PriorityQueue<Tripple> pq= new PriorityQueue<>((a,b)->a.efforts-b.efforts);
        pq.offer(new Tripple(0,0,0));
        while(!pq.isEmpty()){
            Tripple t=pq.poll();
            int r=t.row;
            int c=t.col;
            int currEffort=t.efforts;
            for(int d[]: dir){
                int nR=r+d[0];
                int nC=c+d[1];
                if(nR>=0 && nC>=0 && nR<m && nC<n){
                    int newEffort=Math.max(currEffort,Math.abs(heights[nR][nC]-heights[r][c]));
                    if(newEffort<dist[nR][nC]){
                        dist[nR][nC]=newEffort;
                        pq.offer(new Tripple(nR,nC,newEffort));
                    }
                }
            }  
        }
        return dist[m-1][n-1];
    }
}