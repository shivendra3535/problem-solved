class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int n: nums){
            currSum=Math.max(n,currSum+n);
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}