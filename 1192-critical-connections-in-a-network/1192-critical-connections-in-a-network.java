class Solution {
    public static int timer=0;
    public void dfs(List<List<Integer>> adj, int node, int parent, int tim[],int low[], boolean vis[], List<List<Integer>> bridge){
        vis[node]=true;
        tim[node]=low[node]=timer++;
        for(int nei: adj.get(node)){
            if(nei==parent) continue;
            if(!vis[nei]){
                dfs(adj,nei,node,tim,low,vis,bridge);
                low[node]=Math.min(low[node],low[nei]);
                if(low[nei]>tim[node]){
                    bridge.add(Arrays.asList(nei,node));
                }
            }
            else{
                low[node]=Math.min(low[node],low[nei]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> e: connections){
            int u=e.get(0);
            int v=e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[]= new boolean[n];
        int tim[]= new int[n];
        int low[]= new int[n];
        List<List<Integer>> bridge= new ArrayList<>();
        dfs(adj,0,-1,tim,low,vis,bridge);
        return bridge;
    }
}