class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1 || grid[grid.length-1][grid.length-1]==1) return -1;
        boolean vis[][]= new boolean[grid.length][grid.length];
        Queue<int[]> queue= new LinkedList<>();
        vis[0][0]=true;
        queue.offer(new int[]{0,0,1});
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
        while(!queue.isEmpty()){
            int top[]=queue.poll();
            int r=top[0];
            int c=top[1];
            int dist=top[2];
            if(r==grid.length-1 && c==grid.length-1) return dist;
            for(int d[]: dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid.length && !vis[nr][nc] && grid[nr][nc]==0){
                    vis[nr][nc]=true;
                    queue.offer(new int[]{nr,nc,dist+1});
                }
            }
        }
        return -1;
    }
}