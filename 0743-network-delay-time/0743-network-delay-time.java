class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int max=0;
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int f[]: times){
            int u=f[0];
            int v=f[1];
            int wt=f[2];
            adj.get(u).add(new Pair(v,wt));
        }
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});
        int dist[]= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!pq.isEmpty()){
            int p[]=pq.poll();
            int currDist=p[0];
            int node=p[1];
            for(Pair pr: adj.get(node)){
                if(currDist+pr.wt<dist[pr.node]){
                    dist[pr.node]=currDist+pr.wt;
                    pq.offer(new int[]{dist[pr.node], pr.node});
                }
            }
        }
        for(int i=1; i<n+1; i++){
            int d=dist[i];
            if(d==Integer.MAX_VALUE) return -1;
            max=Math.max(max,d);
        }
        return max;
    }
}