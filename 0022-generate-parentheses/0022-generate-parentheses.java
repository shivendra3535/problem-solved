class Solution {
    public void generateParenthesis(int n,int total,StringBuilder sb, int open, int close, List<String> res){
        if(sb.length()==total){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            generateParenthesis(n,total,sb,open+1,close,res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            generateParenthesis(n,total,sb,open,close+1,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        int total=2*n;
        List<String> res= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        sb.append('(');
        generateParenthesis(n,total,sb,1,0,res);
        return res;
    }
}