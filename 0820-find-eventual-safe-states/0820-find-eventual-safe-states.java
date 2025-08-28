class Solution {
    public boolean dfs(List<List<Integer>> adj,int node, boolean vis[], boolean pathVis[],boolean safe[]){
        vis[node]=true;
        pathVis[node]=true;
        for(int a:adj.get(node)){
            if(!vis[a]){
                if(dfs(adj,a,vis,pathVis,safe)) return true;
            }
            else if(pathVis[a]){
                return true;
            }
        }
        safe[node]=true;
        pathVis[node]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int a:graph[i]){
                adj.get(i).add(a);
            }
        }
        boolean vis[]= new boolean[V];
        boolean pathVis[]=new boolean[V];
        boolean safe[]= new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                boolean b=dfs(adj,i,vis,pathVis,safe);
            }
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0; i<V; i++){
            if(safe[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}