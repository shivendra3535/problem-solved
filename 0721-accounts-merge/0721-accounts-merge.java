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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet dj= new DisjointSet(n);
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0; i<n; i++){
            List<String> emails=accounts.get(i);
            for(int j=1; j<emails.size(); j++){
                if(map.containsKey(emails.get(j))){
                    dj.unionByRank(i,map.get(emails.get(j)));
                }
                else{
                    map.put(emails.get(j),i);
                }
            }
        }
        HashMap<Integer,List<String>> parEm= new HashMap<>();
        for(String email: map.keySet()){
            int account = map.get(email);
            int parent = dj.findUPar(account);
            if(!parEm.containsKey(parent)) parEm.put(parent,new ArrayList<>());
            parEm.get(parent).add(email);
        }
        List<List<String>> res= new ArrayList<>();
        for(int parent: parEm.keySet()){
            List<String> temp= new ArrayList<>();
            List<String> emails=parEm.get(parent); 
            Collections.sort(emails);
            temp.add(accounts.get(parent).get(0));
            temp.addAll(emails);
            res.add(temp);
        }
        return res;
    }
}