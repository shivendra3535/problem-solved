class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int curSum=0;
        for(int n: nums){
            curSum=Math.max(curSum+n,n);
            maxSum=Math.max(maxSum,curSum);
        }
        return maxSum;
    }
}