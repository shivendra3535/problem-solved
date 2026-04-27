class Solution {
    public int[] prevSmaller(int []heights){
        Stack<Integer> st= new Stack<>();
        int ans[]= new int[heights.length];
        for(int i=0; i<heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            int a= st.isEmpty() ? -1 : st.peek();
            ans[i]=a;
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmaller(int []heights){
        Stack<Integer> st= new Stack<>();
        int ans[]= new int[heights.length];
        for(int i=heights.length-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            int a= st.isEmpty() ? heights.length : st.peek();
            ans[i]=a;
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int prev[]=prevSmaller(heights);
        int next[]=nextSmaller(heights);
        int max=Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            int n=next[i];
            int p=prev[i];
            max=Math.max(max,(n-p-1)*heights[i]);
        }
        return max;
    }
}