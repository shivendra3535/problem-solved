class Solution {
    public boolean dfs(int graph[][],int node ,boolean vis[],int colors[], int color){
        vis[node]=true;
        colors[node]=color;
        int nextColor=1-color;
        for(int a: graph[node]){
            if(!vis[a]){
                if(!dfs(graph,a,vis,colors,nextColor)) return false;
            }
            else if(colors[a]==color){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int colors[]= new int[graph.length];
        boolean vis[]= new boolean[graph.length];
        Arrays.fill(colors,-1);
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if(!dfs(graph,i,vis,colors,0)) return false;
            }
        }
        return true;
    }
}