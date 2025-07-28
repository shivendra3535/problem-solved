class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l=0;
        int r=k-1;
        double sum=0;
        for(int i=l; i<=r; i++){
            sum+=nums[i];
        }
        double maxSum=sum;
        while(r<nums.length-1){
            sum=sum-nums[l];
            l++;
            r++;
            sum=sum+nums[r];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum/k;
    }
}