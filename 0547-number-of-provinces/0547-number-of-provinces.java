class Solution {
    public void dfs(int [][] isConnected, boolean vis[],int node){
        vis[node]=true;
        for(int j=0; j<isConnected[0].length; j++){
            if(!vis[j] && isConnected[node][j]==1){
                dfs(isConnected,vis,j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int cnt=0;
        boolean vis[]= new boolean[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                cnt++;
                dfs(isConnected,vis,i);
            }
        }
        return cnt;
    }
}