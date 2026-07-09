class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public boolean isPossible(int [][] grid ,int t){
        if (grid[0][0] > t) return false;
        boolean vis[][]=new boolean[grid.length][grid.length];
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(0,0));
        vis[0][0]= true;
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            int r=p.row;
            int c=p.col;
            if(r==grid.length-1 && c==grid.length-1) return true;
            for(int d[]: dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid.length && !vis[nr][nc] &&  grid[nr][nc]<=t){
                    vis[nr][nc]=true;
                    queue.offer(new Pair(nr,nc));
                }
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int low=0;
        int high=n*n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(grid,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}