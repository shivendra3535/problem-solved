class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb= new StringBuilder();
        Stack<Integer> st= new Stack<>();
        int d=1;
        for(int i=0; i<=pattern.length(); i++){
            st.push(d++);
            if(i==pattern.length() || pattern.charAt(i)=='I'){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}