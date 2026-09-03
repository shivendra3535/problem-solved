class Solution {
    public int targetSum(int []nums, int target, int index, int dp[][], int offset){
        if(index>=nums.length){
            if(target==0) return 1;
            return 0;
        }
        if (target > offset || target < -offset) {
             return 0;
         }
        if(dp[index][target+offset]!=-1) return dp[index][target+offset];
        int add=targetSum(nums,target-nums[index], index+1,dp,offset);
        int sub=targetSum(nums,target+nums[index],index+1,dp,offset);
        dp[index][target+offset]=add+sub;
        return dp[index][target+offset];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0; i<nums.length; i++){ 
            sum+=nums[i];
        }
        int dp[][]= new int[nums.length][2*sum+1];
        for(int i=0; i<nums.length; i++){ 
            Arrays.fill(dp[i],-1);
        }
            if (Math.abs(target) > sum) {
              return 0;
           }
        return targetSum(nums,target,0,dp,sum);
    }
}
