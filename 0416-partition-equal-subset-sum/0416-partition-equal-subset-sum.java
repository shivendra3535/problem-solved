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
    public boolean tabulation(int nums[], int n, int target){
        boolean dp[][]= new boolean[n][target+1];
        for(int i=0; i<n; i++){
            dp[i][0]=true;
        }
        if(nums[0]<=target){
            dp[0][nums[0]]=true;
        }
        for(int index=1; index<n; index++){
            for(int tgt=1; tgt<=target; tgt++){
                boolean notPick=dp[index-1][tgt];
                
                boolean pick = false;

                if (nums[index] <= tgt) {
                    pick = dp[index - 1][tgt - nums[index]];
                }
                
                dp[index][tgt]= pick || notPick;
            }
        }
        return dp[n-1][target];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n: nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        int target = sum / 2;
        /*Boolean dp[][]= new Boolean[nums.length][target+1];
        return memoization(nums,nums.length-1,sum/2,dp);*/
        return tabulation(nums,nums.length,target);
    }
}