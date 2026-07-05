class Solution {
    class DisjointSet{
        ArrayList<Integer> rank= new ArrayList<>();
        ArrayList<Integer> parent= new ArrayList<>();
        DisjointSet(int n){
            for(int i=0; i<n; i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int findUPar(int node){
            if(parent.get(node)==node) return node;
            int ulp=findUPar(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        public void union(int u, int v){
            int ulpu=findUPar(u);
            int ulpv=findUPar(v);
            if(ulpu==ulpv) return;
            if(rank.get(ulpu)<rank.get(ulpv)){
                parent.set(ulpu,ulpv);
            }
            else if(rank.get(ulpv)<rank.get(ulpu)){
                parent.set(ulpv,ulpu);
            }
            else{
                parent.set(ulpu,ulpv);
                rank.set(ulpu,rank.get(ulpu)+1);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int maxRow=Integer.MIN_VALUE;
        int maxCol=Integer.MIN_VALUE;
        for(int s[]: stones){
            maxRow=Math.max(maxRow,s[0]);
            maxCol=Math.max(maxCol,s[1]);
        }
        int n=maxRow+maxCol+2;
        DisjointSet dj= new DisjointSet(n);
        HashSet<Integer> set= new HashSet<>();
        for(int s[]: stones){
            int rowNode=s[0];
            int colNode=s[1]+maxRow+1;
            dj.union(rowNode,colNode);
            set.add(rowNode);
            set.add(colNode);
        }
        int cnt=0;
        for(int s: set){
            if(dj.parent.get(s)==s) cnt++;
        }
        return stones.length-cnt;
    }
}