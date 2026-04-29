class Solution {
    class Pair{
        int node;
        int color;
        Pair(int node,int color){
            this.node=node;
            this.color=color;
        }
    }
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
    public boolean bfs(int graph[][],int node ,boolean vis[],int colors[], int color){
        vis[node]=true;
        colors[node]=color;
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(node,color));
        while(!queue.isEmpty()){
            Pair n=queue.poll();
            int nextColor=1-n.color;
            for(int a: graph[n.node]){
                if(!vis[a]){
                    vis[a]=true;
                    colors[a]=nextColor;
                    queue.offer(new Pair(a,nextColor));
                }
                else if(colors[a]==n.color){
                    return false;
                }
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
                if(!bfs(graph,i,vis,colors,0)) return false;
            }
        }
        return true;
    }
}