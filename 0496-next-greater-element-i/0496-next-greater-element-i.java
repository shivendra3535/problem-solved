class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st= new Stack<>();
        int i=nums2.length-1;
        HashMap<Integer, Integer> map=new HashMap<>();
        while(i>=0){
            int n=nums2[i];
            while(!st.isEmpty() && st.peek()<n){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(n,-1);
            }
            else{
                map.put(n,st.peek());
            }
            st.push(n);
            i--;
        }
        int []ans= new int[nums1.length];
        for(int j=0; j<nums1.length; j++){
            ans[j]=map.get(nums1[j]);
        }
        return ans;
    }
}