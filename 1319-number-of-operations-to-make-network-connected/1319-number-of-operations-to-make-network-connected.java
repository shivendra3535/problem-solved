class Solution {
    
    public void bfs(List<List<Integer>> adj, boolean vis[], int node){
        vis[node]=true;
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int n=queue.poll();
            for(int a: adj.get(n)){
                if(!vis[a]){
                    vis[a]=true;
                    queue.offer(a);
                }
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int cnt=0;
        for(int c[]: connections){
            int u=c[0];
            int v=c[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            cnt++;
        }
        if(cnt<n-1) return -1;
        boolean vis[]= new boolean[n];
        int connected=0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                bfs(adj,vis,i);
                connected++;
            }
        }
        return connected-1;
    }
}