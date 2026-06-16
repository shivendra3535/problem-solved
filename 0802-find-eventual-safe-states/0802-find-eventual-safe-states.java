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
        List<Integer> res= new ArrayList<>();
        List<List<Integer>> adj= new ArrayList<>();
        int V= graph.length;
        int inorder[]= new int[V];
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int i=0; i<V; i++){
            for(int a: graph[i]){
                adj.get(a).add(i);
                inorder[i]++;
            }
        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0; i<V; i++){
            if(inorder[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node=queue.poll();
            res.add(node);
            for(int a: adj.get(node)){
                inorder[a]--;
                if(inorder[a]==0) queue.offer(a);
            }
        }
        Collections.sort(res);
        return res;
    }
}