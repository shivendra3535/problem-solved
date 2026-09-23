class Solution {
    public int recur(int []nums, int index, int prevId, int dp[][]){
        if(index<0) return 0;
        if(dp[index][prevId]!=-1) return dp[index][prevId];
        int notTake=recur(nums,index-1,prevId,dp);
        int take=0;
        if(prevId==nums.length || nums[index]<nums[prevId]) take=1+recur(nums,index-1,index,dp);
        return dp[index][prevId]= Math.max(notTake,take);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length+1];
        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(nums,nums.length-1,nums.length,dp);
    }
}