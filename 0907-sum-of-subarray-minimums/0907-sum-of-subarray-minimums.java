class Solution {
    public static int[] prevSmaller(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int ans[]= new int[arr.length];
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            int a= st.isEmpty() ? -1 : st.peek();
            ans[i]=a;
            st.push(i);
        }
        return ans;
    }
    public static int[] nextSmallerEle(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int i=arr.length-1;
        int[] res = new int[arr.length];
        while(i>=0){
            int num=arr[i];
            while(!st.isEmpty() && arr[st.peek()]>=num){
                st.pop();
            }
            int a=(st.isEmpty()) ? arr.length : st.peek();
            res[i]=a;
            st.push(i);
            i--;
        }
        return res;
    }
    public int sumSubarrayMins(int[] arr) {
        int prevSmaller[]=prevSmaller(arr);
        int nextSmaller[]=nextSmallerEle(arr);
        int MOD=1_000_000_007;
        long sum=0;
        for(int i=0; i<arr.length; i++){
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;

            sum += (long) arr[i] * left * right;
            sum=sum%MOD;
        }
        return (int)sum;
    }
}