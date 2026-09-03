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
    public int tabulation(int[] nums, int target, int offset){
        int dp[][]= new int[nums.length+1][2*offset+1];
        dp[nums.length][offset]=1;
        for(int i=nums.length-1; i>=0; i--){
          for(int tgt=-offset; tgt<=offset; tgt++){
            int add=0;
            int sub=0;
            if(tgt-nums[i]>=-offset && tgt-nums[i]<=offset){
              add=dp[i+1][tgt-nums[i]+offset];}

            if(tgt+nums[i]>=-offset && tgt+nums[i]<=offset){
              sub=dp[i+1][tgt+nums[i]+offset];}
            dp[i][tgt+offset]=add+sub;
          }  
        }
        return dp[0][target+offset];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0; i<nums.length; i++){ 
            sum+=nums[i];
        }
        /*int dp[][]= new int[nums.length][2*sum+1];
        for(int i=0; i<nums.length; i++){ 
            Arrays.fill(dp[i],-1);
        }*/
        if (Math.abs(target) > sum) {
            return 0;
        }
        //return targetSum(nums,target,0,dp,sum);
        return tabulation(nums,target,sum);
    }
}
