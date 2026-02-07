class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int curr=0;
        for(int n: nums){
            curr=Math.max(n, curr+n);
            max=Math.max(max,curr);
        }
       return max;
    }
}