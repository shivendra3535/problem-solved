class Solution {
    public int robbery(int nums[], int index, int dp[], int end){
        if(index>end) return 0;
        if(dp[index]!=-1) return dp[index];
        int take=nums[index]+robbery(nums,index+2,dp,end);
        int notTake=robbery(nums,index+1,dp,end);
        dp[index]=Math.max(take,notTake);
        return dp[index];
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int dp1[]= new int[nums.length];
        int dp2[]= new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int first=robbery(nums,0,dp1,nums.length-2);
        int second=robbery(nums,1,dp2,nums.length-1);
        return Math.max(first,second);
    }
}