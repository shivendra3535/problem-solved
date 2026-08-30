class Solution {
    public boolean memoization(int nums[], int index, int target, Boolean dp[][]){
        if(target==0) return true;

        if(index==0){
            return nums[index]==target;
        }
        if(dp[index][target]!=null) return dp[index][target];
        boolean notPick= memoization(nums,index-1,target,dp);
        boolean pick=false;
        if(nums[index]<=target){
            pick=memoization(nums,index-1,target-nums[index],dp);
        }
        dp[index][target]=pick || notPick;
        return dp[index][target];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n: nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        int target = sum / 2;
        Boolean dp[][]= new Boolean[nums.length][target+1];
        return memoization(nums,nums.length-1,sum/2,dp);
    }
}