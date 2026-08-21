class Solution {
    public int  recur(int index,int nums[], int dp[]){
        if(index>=nums.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int take=nums[index]+recur(index+2,nums,dp);
        int notTake=recur(index+1,nums,dp);
        dp[index]= Math.max(take,notTake);
        return dp[index];
    }
    public int rob(int[] nums) {
        int dp[]= new int[nums.length];
        Arrays.fill(dp,-1);
        return recur(0,nums,dp);
        
    }
}