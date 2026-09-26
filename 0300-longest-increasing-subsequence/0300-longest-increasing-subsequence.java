class Solution {
    public int recur(int []nums, int index, int prevId, int dp[][]){
        if(index<0) return 0;
        if(dp[index][prevId]!=-1) return dp[index][prevId];
        int notTake=recur(nums,index-1,prevId,dp);
        int take=0;
        if(prevId==nums.length || nums[index]<nums[prevId]) take=1+recur(nums,index-1,index,dp);
        return dp[index][prevId]= Math.max(notTake,take);
    }
    public int tabulation(int nums[]){
        int n=nums.length;
        int dp[][]= new int[n+1][n+1];
        for(int index=1; index<=n; index++){
            for(int prev=0; prev<=n; prev++){
                int notTake=dp[index-1][prev];
                int take=0;
                if(prev==n || nums[index-1]<nums[prev]){
                    take=1+dp[index-1][index-1];
                }
                dp[index][prev]=Math.max(take,notTake);
            }
        }
        return dp[n][n];
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length+1];
        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i],-1);
        }
        //return recur(nums,nums.length-1,nums.length,dp);
        return tabulation(nums);
    }
}