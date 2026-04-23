class Solution {
    int nodes;
    int edge;
    public void dfs(int [][]adj, int node, boolean vis[]){
        vis[node]=true;
        nodes++;
        for(int i=0; i<adj.length; i++){
            if(adj[node][i]==1){
                edge++;

                if(!vis[i]){
                dfs(adj,i,vis);
               }
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean vis[]= new boolean[n];
        int[][] adj = new int[n][n];

         for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u][v] = 1;
            adj[v][u] = 1; 
         }
        int complete=0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                nodes=0;
                edge=0;
                dfs(adj,i,vis);
                edge = edge / 2;
                int expected = nodes * (nodes - 1) / 2;
                if (edge == expected) {
                    complete++;
                }
            }
        }
        return complete;
    }
}