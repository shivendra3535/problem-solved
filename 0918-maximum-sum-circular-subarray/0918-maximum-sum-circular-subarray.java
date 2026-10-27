class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int tot=0;

        int currMax=0;
        int currMin=0;
        for(int n: nums){
            currMax=Math.max(currMax+n, n);
            maxSum=Math.max(maxSum, currMax);

            currMin=Math.min(currMin+n,n);
            minSum=Math.min(currMin,minSum);

            tot+=n;
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum,tot-minSum);
    }
}