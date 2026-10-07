class Solution {

    HashSet<String> ans= new HashSet<>();
    int minRem=Integer.MAX_VALUE;
    public void backtrack(String s, int index, int removals, int open, StringBuilder curr){
        if(index==s.length()){
            if(open==0){
                if(removals<minRem){
                    ans.clear();
                    minRem=removals;
                    ans.add(curr.toString());
                }
                else if(removals==minRem){
                    ans.add(curr.toString());
                }
            }
            return;
        }
        if(removals>minRem) return;

        if(s.charAt(index)!='(' && s.charAt(index)!=')'){
            curr.append(s.charAt(index));
            backtrack(s,index+1,removals,open,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        else if(s.charAt(index)=='('){
            //taking it
            curr.append(s.charAt(index));
            backtrack(s,index+1,removals,open+1,curr);
            curr.deleteCharAt(curr.length()-1);

            backtrack(s,index+1,removals+1,open,curr);
        }
        else{
            if(open>0){
                curr.append(s.charAt(index));
                backtrack(s,index+1,removals,open-1,curr);
                curr.deleteCharAt(curr.length()-1);
            }
            backtrack(s,index+1,removals+1,open,curr);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        backtrack(s,0,0,0,new StringBuilder());
        return new ArrayList<>(ans);
    }
}