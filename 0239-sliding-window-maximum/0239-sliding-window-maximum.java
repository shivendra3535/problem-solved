class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res= new  ArrayList<>();
        Deque<Integer> dq= new LinkedList<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1) res.add(nums[dq.peekFirst()]);
        }
        int[] result = new int[res.size()];
for (int i = 0; i < res.size(); i++) {
    result[i] = res.get(i);
}
return result;
    }
}