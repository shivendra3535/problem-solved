class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int totSum=0;
        int curr1=0;
        int curr2=0;
        for(int i=0; i<nums.length; i++){
            curr1=Math.max(nums[i],curr1+nums[i]);
            curr2=Math.min(nums[i],curr2+nums[i]);

            maxSum=Math.max(maxSum,curr1);
            minSum=Math.min(minSum,curr2);

            totSum+=nums[i];
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum,totSum-minSum);
    }
}