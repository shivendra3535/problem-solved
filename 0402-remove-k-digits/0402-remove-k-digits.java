class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st= new Stack<>();
        for(char c: num.toCharArray()){
            int n=c-'0';
            while(!st.isEmpty() && n<st.peek() && k>0){
                st.pop();
                k--;
            }
            st.push(n);
        }
        while(k>0){
            st.pop();
            k--;
        }
        char arr[]= new char[st.size()];
        for(int i=arr.length-1; i>=0; i--){
            arr[i]=(char)(st.pop()+'0');
        }
        int i=0;
        while(i<arr.length && arr[i]=='0'){
            i++;
        }
        StringBuilder sb= new StringBuilder();
        while(i<arr.length){
            sb.append(arr[i]);
            i++;
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}