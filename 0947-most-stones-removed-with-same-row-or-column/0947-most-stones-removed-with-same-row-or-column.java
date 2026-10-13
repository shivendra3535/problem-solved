class Solution {
    class DJ{
        List<Integer> par= new ArrayList<>();
        List<Integer> rank= new ArrayList<>();
        DJ(int n){
            for(int i=0; i<n; i++){
                par.add(i);
                rank.add(0);
            }
        }

        public int findUPar(int node){
            if(node==par.get(node)) return node;
            int up=findUPar(par.get(node));
            par.set(node,up);
            return up;
        }

        public void union(int u, int v){
            int upu = findUPar(u);
            int upv = findUPar(v);
            int ru = rank.get(upu);
            int rv = rank.get(upv);
            if(upu==upv) return;
            if(ru>rv){
                par.set(upv,upu);
            }
            else if(ru<rv){
                par.set(upu,upv);
            }
            else{
                par.set(upv,upu);
                rank.set(upu,rank.get(upu)+1);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int maxR=Integer.MIN_VALUE;
        int maxC=Integer.MIN_VALUE;
        for(int st[]: stones){
            maxR=Math.max(maxR,st[0]);
            maxC=Math.max(maxC,st[1]);
        }
        int n=maxR+maxC+2;
        DJ dj= new DJ(n);
        HashSet<Integer> set= new HashSet<>();
        for(int st[]: stones){
            int row=st[0];
            int col=st[1]+maxR+1;
            dj.union(row,col);
            set.add(row);
            set.add(col);
        }
        int cnt=0;
        for(int s: set){
            if(dj.findUPar(s)==s) cnt++;
        }
        return stones.length-cnt;
    }
}