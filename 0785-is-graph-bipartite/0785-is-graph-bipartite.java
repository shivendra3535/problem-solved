class Solution {
    public boolean dfs(int node,int [][] graph, boolean vis[], int colors[], int color){
        vis[node]=true;
        colors[node]=color;
        int nextColor=1-color;
        for(int a: graph[node]){
            if(!vis[a]){
                if(!dfs(a,graph,vis,colors,nextColor)) return false;
            }
            else if(colors[a]==color) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        boolean vis[]= new boolean[graph.length];
        int colors[]= new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(!dfs(i,graph,vis,colors,0)) return false;
            }
        }
        return true;
    }
}