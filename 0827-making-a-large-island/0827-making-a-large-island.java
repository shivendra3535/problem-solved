class Solution {
    class DSU{
        ArrayList<Integer> size= new ArrayList<>();
        ArrayList<Integer> parent= new ArrayList<>();
        DSU(int n){
            for(int i=0; i<n; i++){
                size.add(1);
                parent.add(i);
            }
        }
        
        public int findParent(int node){
            if(node==parent.get(node)) return node;
            parent.set(node,findParent(parent.get(node)));
            return parent.get(node);
        }
        
        public void union(int u, int v){
            int Upu=findParent(u);
            int Upv= findParent(v);
            if(Upu==Upv) return;
            if(size.get(Upu)<size.get(Upv)){
                parent.set(Upu,Upv);
                size.set(Upv,size.get(Upv)+size.get(Upu));
            }
            else{
                parent.set(Upv,Upu);
                size.set(Upu,size.get(Upv)+size.get(Upu));
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        int n=grid.length;
        int maxSize=1;
        DSU ds= new DSU(n*n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int node=i*n+j;
                    for(int d[]: dir){
                        int nr=i+d[0];
                        int nc=j+d[1];
                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                            int adjN=nr*n+nc;
                            if(ds.findParent(node) != ds.findParent(adjN)){
                                ds.union(node,adjN);
                                int parent = ds.findParent(node);
                                int size = ds.size.get(parent);
                                maxSize = Math.max(maxSize, size);
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    int cnt=1;
                    HashSet<Integer> set = new HashSet<>();
                    for(int d[]: dir){
                        int nr=i+d[0];
                        int nc=j+d[1];
                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                            set.add(ds.findParent(nr*n + nc));
                        }
                    }
                    for(int parent : set){
                   cnt += ds.size.get(parent);
                }
                maxSize=Math.max(maxSize,cnt);
                }
            }
        }
        return maxSize;
    }
}