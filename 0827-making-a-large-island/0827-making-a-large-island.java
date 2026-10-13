class Solution {
    class DS{
        ArrayList<Integer> par= new ArrayList<>();
        ArrayList<Integer> size= new ArrayList<>();
        DS(int n){
            for(int i=0; i<n; i++){
                par.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node){
            if(par.get(node)==node) return node;
            int up=findUPar(par.get(node));
            par.set(node,up);
            return up;
        }

        public void union(int u, int v){
            int upu=findUPar(u);
            int upv=findUPar(v);

            if(upu==upv) return;
            if(size.get(upu)>size.get(upv)){
                par.set(upv,upu);
                size.set(upu, size.get(upu)+size.get(upv));
            }
            else{
                par.set(upu,upv);
                size.set(upv, size.get(upu)+size.get(upv));
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n= grid.length;
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int maxSize=1;
        DS ds= new DS(n*n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    for(int d[]:dir){
                        int nr=i+d[0];
                        int nc=j+d[1];
                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                            int node=i*n+j;
                            int adj=nr*n+nc;
                            if(ds.findUPar(node)!=ds.findUPar(adj)){
                                ds.union(node,adj);
                                int size=ds.size.get(ds.findUPar(node));
                                maxSize=Math.max(maxSize,size);
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
                    HashSet<Integer> set= new HashSet<>();
                    for(int d[]: dir){
                        int nr=i+d[0];
                        int nc=j+d[1];
                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                            set.add(ds.findUPar(nr*n+nc));
                        }
                    }
                    for(int par: set){
                        cnt+=ds.size.get(par);
                    }
                    maxSize=Math.max(maxSize,cnt);
                }

            }
        }
        return maxSize;
    }
}