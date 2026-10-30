class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        Deque<Integer> dq= new LinkedList<>();
        int j=0;
        for(int i=0; i<nums.length; i++){
            //removing element out of window
            while(!dq.isEmpty() && i-k>=dq.peekFirst()){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                ans[j++]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}