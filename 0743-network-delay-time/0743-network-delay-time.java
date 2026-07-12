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
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int t[]: times){
            int u=t[0];
            int v=t[1];
            int wt=t[2];
            adj.get(u).add(new Pair(v,wt));
        }
        int dist[]= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.wt-b.wt);
        dist[k]=0;
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int currWt=p.wt;
            int node=p.node;
            for(Pair nei: adj.get(node)){
                if(currWt+nei.wt<dist[nei.node]){
                    dist[nei.node]=currWt+nei.wt;
                    pq.offer(new Pair(nei.node,dist[nei.node]));
                }
            }
        }
        int max = 0;
for (int i = 1; i <= n; i++) {
    if (dist[i] == Integer.MAX_VALUE)
        return -1;
    max = Math.max(max, dist[i]);
}
return max;
    }
}