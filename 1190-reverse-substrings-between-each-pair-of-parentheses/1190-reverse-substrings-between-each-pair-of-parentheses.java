class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st= new Stack<>();
        char c[]=s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.addLast(i);
            }
            else if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                st.addLast(i);
            }
            else{
                List<Integer> temp= new ArrayList<>();
                while(!st.isEmpty() && s.charAt(st.peek())!='('){
                    temp.add(st.pop());
                }
                st.pop();
                for(int in: temp){
                    st.push(in);
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.append(s.charAt(st.pop()));
        }
        return sb.reverse().toString();
    }
}