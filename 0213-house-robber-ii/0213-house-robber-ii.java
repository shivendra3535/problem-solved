class Solution {
    public int robbery(int nums[], int index, int dp[], int end){
        if(index>end) return 0;
        if(dp[index]!=-1) return dp[index];
        int take=nums[index]+robbery(nums,index+2,dp,end);
        int notTake=robbery(nums,index+1,dp,end);
        dp[index]=Math.max(take,notTake);
        return dp[index];
    }
    public int tabulation(int nums[], int start, int end){
        int dp[]= new int[nums.length];
        for(int i=end; i>=start; i--){
            int take= nums[i]+ ((i+2)>end?0:dp[i+2]);
            int notTake=(i+1)>end?0:dp[i+1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[start];
    }

    public int spaceOptimization(int nums[], int start, int end){
        int next2=0;
        int next1=0;
        for(int i=end; i>=start; i--){
            int take= nums[i]+next2;
            int notTake=next1;
            int current=Math.max(take,notTake);
            next2=next1;
            next1=current;
        }
        return next1;
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        /* Memoization:
        if(nums.length==1) return nums[0];
        int dp1[]= new int[nums.length];
        int dp2[]= new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int first=robbery(nums,0,dp1,nums.length-2);
        int second=robbery(nums,1,dp2,nums.length-1);
        return Math.max(first,second);*/

        /* Tabulation
        int first=tabulation(nums,0,nums.length-2);
        int second=tabulation(nums,1,nums.length-1);
        return Math.max(first,second);*/

        int first=spaceOptimization(nums,0,nums.length-2);
        int second=spaceOptimization(nums,1,nums.length-1);
        return Math.max(first,second);
    }
}