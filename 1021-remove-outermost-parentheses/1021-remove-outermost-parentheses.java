class Solution {
    public String removeOuterParentheses(String s) {
        int start=-1;
        int cnt=0;
        StringBuilder sb= new StringBuilder();
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                if(cnt==0){
                    start=i;
                }
                cnt++;
            }
            else{
                if(cnt==1){
                    sb.append(s.substring(start+1,i));
                }
                cnt--;
            }
        }
        return sb.toString();
    }
}