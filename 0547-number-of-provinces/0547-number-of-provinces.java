class DisjointSet{
    ArrayList<Integer> rank= new ArrayList<>();
    ArrayList<Integer> parent= new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0; i<n; i++){
            rank.add(0);
            parent.add(i);
        }
    }
    
    public int findUPar(int node){
        if(node==parent.get(node)) return node;
        
        int ulp=findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u, int v){
        int ulpu=findUPar(u);
        int ulpv=findUPar(v);
        if(ulpu==ulpv) return;
        if(rank.get(ulpv)<rank.get(ulpu)){
            parent.set(ulpv,ulpu);
        }
        else if(rank.get(ulpu)<rank.get(ulpv)){
            parent.set(ulpu,ulpv);
        }
        else{
            parent.set(ulpv, ulpu);
            int rankU=rank.get(ulpu);
            rank.set(ulpu, rankU+1);
        }
    }
}
class Solution {
    /*
    public void dfs(int node, boolean vis[],int[][] isConnected){
        vis[node]=true;
        for(int i=0; i<isConnected[0].length; i++){
            if(isConnected[node][i]==1 && !vis[i]){
                dfs(i,vis,isConnected);
            }
        }
    }
    */
    public int findCircleNum(int[][] isConnected) {
        /*
        boolean vis[]= new boolean[isConnected.length];
        int cnt=0;
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                cnt++;
                dfs(i,vis,isConnected);
            }
        }
        return cnt; */
        int n=isConnected.length;
        DisjointSet dj= new DisjointSet(n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && isConnected[i][j]==1){
                    dj.unionByRank(i,j);
                }
            }
        }
        int cnt=0;
        for(int i=0; i<n; i++){
            if(dj.parent.get(i)==i) cnt++;
        }
        return cnt;
    }
}