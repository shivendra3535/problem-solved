class Solution {
    public void dfs(int node, boolean vis[],int[][] isConnected){
        vis[node]=true;
        for(int i=0; i<isConnected[0].length; i++){
            if(isConnected[node][i]==1 && !vis[i]){
                dfs(i,vis,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean vis[]= new boolean[isConnected.length];
        int cnt=0;
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                cnt++;
                dfs(i,vis,isConnected);
            }
        }
        return cnt;
    }
}