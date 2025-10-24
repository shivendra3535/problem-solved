class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum= Integer.MIN_VALUE;
        int sum1=0;
        int minSum= Integer.MAX_VALUE;
        int sum2=0;
        int totalSum=0;
        int n= nums.length;
        for(int i=0; i<n; i++){
            sum1+= nums[i];
            maxSum= Math.max(maxSum, sum1);
            if(sum1<0) sum1=0;
            
            sum2+=nums[i];
            minSum=Math.min(minSum, sum2);
            if(sum2>0) sum2=0;

            totalSum+=nums[i];
        }
        if (maxSum < 0) return maxSum;
        
        return Math.max(maxSum, (totalSum-minSum));
    }
}