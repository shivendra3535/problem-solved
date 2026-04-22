class Solution {
    public void dfs(int [][]isConnected, boolean vis[], int node){
        vis[node]=true;
        for(int j=0; j<isConnected[0].length; j++){
            if(isConnected[node][j]==1 && !vis[j]){
                dfs(isConnected,vis,j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int size=isConnected.length;
        boolean vis[]= new boolean[size];
        int cnt=0;
        for(int i=0; i<size; i++){
            if(!vis[i]){
                dfs(isConnected,vis,i);
                cnt++;
            }
        }
        return cnt;
    }
}