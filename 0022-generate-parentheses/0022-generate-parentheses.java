class Solution {
    public void generateParenthesis(String ans, int total, int open,int close, int n,List<String> res){
        if(ans.length()==total){
            res.add(ans);
            return;
        }
        if(open<n){
            generateParenthesis(ans+"(",total,open+1,close,n,res);
        }

        if(close<open){
            generateParenthesis(ans+")",total,open,close+1,n,res);
        }
    }
    public List<String> generateParenthesis(int n) {
        int total=2*n;
        String ans="(";
        List<String> res= new ArrayList<>();
        generateParenthesis(ans,total,1,0,n,res);
        return res;
    }
}