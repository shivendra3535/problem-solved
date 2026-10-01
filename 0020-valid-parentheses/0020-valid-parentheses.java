class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else{
                if(st.isEmpty()) return false;
                char c1=st.pop();
                if((c1=='(' && c!=')') || (c1=='[' && c!=']') || (c1=='{'&& c!='}')) return false;
            }
        }
        return st.isEmpty();
    }
}