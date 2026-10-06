class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st= new Stack<>();
        int cnt=0;
        for(char c: s.toCharArray()){
            if(c=='(') st.push(c);
            else{
                if(st.isEmpty()) cnt++;
                else{
                    st.pop();
                }
            }
        }
        return cnt+st.size();
    }
}