class Pair {
    int node;
    int color;
    Pair(int node, int color) {
        this.node = node;
        this.color = color;
    }
}

class Solution {
    /* public boolean bfs(int [][]graph, int node, boolean vis[], int colors[]) {
        Queue<Pair> queue = new LinkedList<>();
        vis[node] = true;
        colors[node] = 0; // start with color 0
        queue.offer(new Pair(node, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int pNode = p.node;
            int pColor = p.color;
            int nextColor = 1 - pColor;

            for (int a : graph[pNode]) { // ✅ fix here
                if (!vis[a]) {
                    vis[a] = true;
                    colors[a] = nextColor; // ✅ fix here
                    queue.offer(new Pair(a, nextColor));
                } else if (colors[a] == pColor) {
                    return false; // conflict → not bipartite
                }
            }
        }
        return true;
    } */
    public boolean dfs(int graph[][],int node,int color,boolean vis[], int colors[]){
        vis[node]=true;
        colors[node]=color;
        int nextColor=1-color;
        for(int a: graph[node]){
            if(!vis[a]){
                if(!dfs(graph,a,nextColor,vis,colors)) return false;
            }
            else if(colors[a]==color){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        int[] colors = new int[V];
        Arrays.fill(colors, -1);

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (!dfs(graph, i,0, vis, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
}
