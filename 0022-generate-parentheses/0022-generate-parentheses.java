class Solution {
    public void recur(int n, List<String>res, String ds, int cntOpen, int cntClose){
        if(ds.length()==2*n){
            res.add(new String(ds));
            return;
        }

        if(cntOpen<n) recur(n,res,ds+"(",cntOpen+1,cntClose);
        if(cntClose <n && cntClose<cntOpen) recur(n,res,ds+")",cntOpen,cntClose+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        recur(n,res,"(",1,0);
        return res;
    }
}