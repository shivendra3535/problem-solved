class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N=nums.length;
        int i=2*N-1;
        Stack<Integer> st= new Stack<>();
        int ans[]= new int[N];
        while(i>=0){
            int num=nums[i%N];
            while(!st.isEmpty() && st.peek()<=num){
                st.pop();
            }
            if (i < N) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(num);
            i--;
        }
        return ans;
    }
}