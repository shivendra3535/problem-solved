class Solution {
    public boolean dfs(int [][]graph, boolean vis[],boolean pathVis[],boolean safe[],int node){
        vis[node]=true;
        pathVis[node]=true;
        for(int a: graph[node]){
            if(!vis[a]){
                if(dfs(graph,vis,pathVis,safe,a)) return true;
            }
            else if(pathVis[a]) return true;
        }
        pathVis[node]=false;
        safe[node]=true;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean vis[]= new boolean[graph.length];
        boolean pathVis[]= new boolean[graph.length];
        boolean safe[]= new boolean[graph.length];
        List<Integer> res= new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                boolean cycle= dfs(graph,vis,pathVis,safe,i);
            }
        }
        for(int i=0; i<graph.length; i++){
            if(safe[i]) res.add(i);
        }
        return res;
    }
}