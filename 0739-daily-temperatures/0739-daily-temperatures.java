class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[]= new int[temperatures.length];
        Stack<Integer> st= new Stack<>();
        for(int i=temperatures.length-1; i>=0; i--){
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]) st.pop();
            int a= st.isEmpty()? 0 : st.peek()-i;
            ans[i]=a;
            st.push(i);
        }
        return ans;
    }
}