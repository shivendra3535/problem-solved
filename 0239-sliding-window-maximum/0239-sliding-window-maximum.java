class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ans[]= new int[n-k+1];
        Deque<Integer> dq= new LinkedList<>();
        int i=0;
        for(int right=0; right<n; right++){
            if(!dq.isEmpty() && dq.peekFirst()<=right-k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[right]) dq.pollLast();
            dq.offerLast(right);
            if(right>=k-1){
                ans[i++]=nums[dq.peekFirst()];
            }
        }
       return ans;
    }
}