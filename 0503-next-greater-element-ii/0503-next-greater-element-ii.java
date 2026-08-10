class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st= new Stack<>();
        int n=nums.length;
        int N=2*n-1;
        int nextGre[]= new int[n];
        for(int i=N; i>=0; i--){
            int curr=nums[i%n];
            while(!st.isEmpty() && curr>=st.peek()){
                st.pop();
            }
            
            if(i<n){
                int ans= st.isEmpty()? -1:st.peek();
                nextGre[i]=ans;
            }
            st.push(curr);
        }
        return nextGre;
    }
}