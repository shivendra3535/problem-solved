class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int sum1=0;
        int sum2=0;
        int total=0;
        for(int n: nums){
            sum1=Math.max(n,sum1+n);
            maxSum=Math.max(maxSum,sum1);

            sum2=Math.min(n,sum2+n);
            minSum=Math.min(minSum,sum2);

            total+=n;
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum,total-minSum);
    }
}