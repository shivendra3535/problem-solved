class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public static final int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int f[]: roads){
            int u=f[0];
            int v=f[1];
            int wt=f[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        long dist[]= new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        int ways[]= new int[n];
        PriorityQueue<long[]> pq= new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0,0});
        dist[0]=0;
        ways[0]=1;
        while(!pq.isEmpty()){
            long []t=pq.poll();
            long currDis=t[0];
            int node=(int)t[1];
            if(currDis>dist[node]) continue;
            for(Pair p: adj.get(node)){
                long newWt=currDis+p.wt;
                if(newWt<dist[p.node]){
                    dist[p.node]=newWt;
                    ways[p.node]=ways[node];
                    pq.offer(new long[]{dist[p.node],p.node});
                }
                else if(newWt==dist[p.node]){
                    ways[p.node]=(ways[p.node]+ways[node])%MOD;
                }
            }
        }
        return ways[n-1]%MOD;
    }
}