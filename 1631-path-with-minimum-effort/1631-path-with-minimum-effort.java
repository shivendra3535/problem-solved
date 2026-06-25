class Solution {
    class Triple{
        int row;
        int col;
        int effort;
        Triple(int row,int col, int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int diff[][]= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(diff[i],Integer.MAX_VALUE);
        }
        diff[0][0]=0;
        PriorityQueue<Triple> pq= new PriorityQueue<>((a,b)->a.effort-b.effort);
        pq.offer(new Triple(0,0,0));
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            Triple p= pq.poll();
            int row=p.row;
            int col=p.col;
            int effort=p.effort;
            for(int d[]:dir){
                int nR=row+d[0];
                int nC=col+d[1];
                if(nR>=0 && nC>=0 && nR<m && nC<n){
                    int newEffort=Math.max(effort,Math.abs(heights[nR][nC]-heights[row][col]));
                    if(newEffort<diff[nR][nC]){
                        diff[nR][nC]=newEffort;
                        pq.offer(new Triple(nR,nC,newEffort));
                    }
                }
            }
        }
        return diff[m-1][n-1];
    }
}