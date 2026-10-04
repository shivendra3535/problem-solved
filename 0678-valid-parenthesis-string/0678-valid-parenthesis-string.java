class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st= new Stack<>();
        Stack<Integer> st2= new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c=='('){
                st.push(i);
            }
            else if(c=='*'){
                st2.push(i);
            }
            else{
                if(st.isEmpty() && st2.isEmpty()) return false;
                else if(st.isEmpty() && !st2.isEmpty()) st2.pop();
                else{
                    st.pop();
                }
            }
        }
        if(st.isEmpty()) return true;
        while(!st.isEmpty() && !st2.isEmpty()){
            int open=st.pop();
            int star=st2.pop();
            if(open>star) return false;
        }
        return st.isEmpty();
    }
}