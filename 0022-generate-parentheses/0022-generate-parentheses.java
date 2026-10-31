class Solution {
    public void generate(int n, int cntOp, int cntClose, String ds, List<String> res){
        if(ds.length()==2*n){
            res.add(new String(ds));
            return;
        }
        if(cntOp<n){
            generate(n,cntOp+1,cntClose,ds+"(",res);
        }

        if(cntClose<cntOp && cntClose<n){
            generate(n,cntOp,cntClose+1,ds+")",res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generate(n,1,0,"(",res);
        return res;
    }
}