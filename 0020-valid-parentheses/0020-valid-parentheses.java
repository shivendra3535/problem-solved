class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else{
                if(st.isEmpty()) return false;
                char c1=st.peek();
                if((c1=='(' && c!=')') || (c1=='[' && c!=']') || (c1=='{' && c!='}')) return false;
                else st.pop();
            }
        }
        return st.isEmpty();
    }
}