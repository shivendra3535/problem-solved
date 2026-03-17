class Solution {
    public boolean isValid(String s) {
        Stack<Character> st1= new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                st1.push(c);
            }
            else{
                if(st1.isEmpty()) return false; 
                char c1=st1.peek();    
                if((c1=='(' && c!=')') || (c1=='[' && c!=']') || (c1=='{' && c!='}')){
                    return false;
                }
                else{
                    st1.pop();
                }
            }
        }
        
        return st1.isEmpty();
    }
}