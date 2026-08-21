class Solution {
    public int  recur(int index,int nums[], int dp[]){
        if(index>=nums.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int take=nums[index]+recur(index+2,nums,dp);
        int notTake=recur(index+1,nums,dp);
        dp[index]= Math.max(take,notTake);
        return dp[index];
    }
    public int tabulation(int nums[]){
        int dp[]= new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            int take= nums[i] + ((i+2>=nums.length)?0:dp[i+2]);
            int notTake=(i+1>=nums.length)?0:dp[i+1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[0];
    }
    public int spaceOptimization(int nums[]){
        int n=nums.length;
        int next2=0;
        int next1=0;
        for(int i=n-1; i>=0; i--){
            int take=nums[i]+next2;
            int notTake=next1;

            int current=Math.max(take,notTake);
            next2=next1;
            next1=current;
        }
        return next1;
    }
    public int rob(int[] nums) {
        /*int dp[]= new int[nums.length];
        Arrays.fill(dp,-1);
        return recur(0,nums,dp); */
        return tabulation(nums);
    }
}