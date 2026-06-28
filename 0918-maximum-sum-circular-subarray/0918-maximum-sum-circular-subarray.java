class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int totSum=0;
        int curSum1=0;
        int curSum2=0;
        for(int n: nums){
            curSum1=Math.max(curSum1+n,n);
            curSum2=Math.min(curSum2+n,n);
            maxSum=Math.max(curSum1,maxSum);
            minSum=Math.min(curSum2,minSum);
            totSum+=n;
        }
        if (maxSum < 0) return maxSum;
        return Math.max(maxSum,totSum-minSum);
    }
}