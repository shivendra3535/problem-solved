class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum1=0;
        int sum2=0;
        int total=0;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        for(int n: nums){
            sum1=Math.max(n,n+sum1);
            maxSum=Math.max(maxSum,sum1);

            sum2=Math.min(n,n+sum2);
            minSum=Math.min(minSum,sum2);
            total+=n;
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum,total-minSum);

    }
}