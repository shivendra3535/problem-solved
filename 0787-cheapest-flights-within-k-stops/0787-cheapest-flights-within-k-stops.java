class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    class Tup{
        int node;
        int cost;
        int stops;
        Tup(int node, int cost, int stops){
            this.node=node;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int f[]: flights){
            int u=f[0];
            int v=f[1];
            int wt=f[2];
            adj.get(u).add(new Pair(v,wt));
        }
        int cost[]= new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        Queue<Tup> queue= new LinkedList<>();
        cost[src]=0;
        queue.offer(new Tup(src,0,0));
        while(!queue.isEmpty()){
            Tup t= queue.poll();
            int node=t.node;
            int costs=t.cost;
            int stops=t.stops;
            if(stops>k) continue;
            for(Pair p: adj.get(node)){
                if(p.wt+costs<cost[p.node]){
                    cost[p.node]=p.wt+costs;
                    queue.offer(new Tup(p.node,cost[p.node],stops+1));
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE ? -1:cost[dst];
    }
}