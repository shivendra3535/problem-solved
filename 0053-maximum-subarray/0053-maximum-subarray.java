class Solution {
    public int maxSubArray(int[] nums) {
        int curSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int n: nums){
            curSum=Math.max(n,curSum+n);
            maxSum=Math.max(maxSum,curSum);
        }
        return maxSum;
    }
}