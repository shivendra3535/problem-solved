class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st= new Stack<>();
        int ans[]=new int[temperatures.length];
        for(int i=temperatures.length-1; i>=0; i--){
            int curr=temperatures[i];
            while(!st.isEmpty() && curr>=temperatures[st.peek()]){
                st.pop();
            }
            int a= st.isEmpty() ? 0 : (st.peek()-i);
            ans[i]=a;
            st.push(i);
        }
        return ans;
    }
}