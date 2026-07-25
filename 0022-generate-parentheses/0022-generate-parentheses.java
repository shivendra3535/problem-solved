class Solution {
    public void generate(int n, int cntOpen, int cntClose, String ds, List<String> res){
        if(ds.length()==2*n){
            res.add(new String(ds));
            return;
        }
        if(cntOpen<n) generate(n,cntOpen+1, cntClose, ds+'(', res);
        if(cntClose<n && cntOpen>cntClose) generate(n, cntOpen, cntClose+1, ds+')', res);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generate(n,1,0,"(", res);
        return res;
    }
}