class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        int par[]= new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else if(s.charAt(i)==')'){
                int open=st.pop();
                par[open]=i;
                par[i]=open;
            }
        }

        int i=0;
        int direction=1;
        StringBuilder sb= new StringBuilder();
        while(i>=0 && i<n){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                i=par[i];
                direction=-direction;
            }
            else{
                sb.append(s.charAt(i));
            }
            i+=direction;
        }
        return sb.toString();
    }
}