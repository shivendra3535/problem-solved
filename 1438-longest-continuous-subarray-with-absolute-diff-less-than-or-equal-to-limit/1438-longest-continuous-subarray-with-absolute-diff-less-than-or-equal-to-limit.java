class Solution {
    public int longestSubarray(int[] nums, int k) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            int n=nums[right];
            while(!maxDeque.isEmpty() && n>nums[maxDeque.peekLast()]){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            
            while(!minDeque.isEmpty() && n<nums[minDeque.peekLast()]){
                minDeque.pollLast();
            }

            minDeque.offerLast(right);

            while(left<=right && nums[maxDeque.peekFirst()]-nums[minDeque.peekFirst()]>k){
                if(maxDeque.peekFirst()==left) maxDeque.pollFirst();
                if(minDeque.peekFirst()==left) minDeque.pollFirst();
                left++;
            }
            
            ans=Math.max(ans,right-left+1);
        }

        return ans;
    }
}