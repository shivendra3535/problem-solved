class Solution {
    class Tupple{
        int point[];
        double dist;
        Tupple(int point[]){
            this.point=point;
            int xsqr=point[0]*point[0];
            int ysqr=point[1]*point[1];
            this.dist=Math.sqrt(xsqr+ysqr);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tupple> pq= new PriorityQueue<>((a,b)->Double.compare(b.dist,a.dist));
        for(int p[]: points){
            pq.offer(new Tupple(p));
            if(pq.size()>k) pq.poll();
        }
        int ans[][]= new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll().point;
        }
        return ans;
    }
}