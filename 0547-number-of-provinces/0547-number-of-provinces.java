class Solution {
    public void dfs(int[][] isConnected,int node,boolean vis[]){
        vis[node]=true;
        for(int j=0; j<isConnected.length; j++){
            if( isConnected[node][j]==1 && !vis[j]){
                vis[j]=true;
                dfs(isConnected,j,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int size=isConnected.length;
        boolean vis[]= new boolean[size];
        int cnt=0;
        for(int i=0; i<isConnected.length; i++){
                if(vis[i]==false){
                    dfs(isConnected,i,vis);
                    cnt++;
                }
            }
        return cnt;
    }
}