class Solution {
    public int memoization(int []cost, int index, int dp[]){
        if(index>=cost.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int first=cost[index]+memoization(cost,index+1,dp);
        int second=cost[index]+memoization(cost,index+2,dp);
        dp[index]=Math.min(first,second);
        return dp[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[]= new int[cost.length];
        Arrays.fill(dp,-1);
        int first=memoization(cost,0,dp);
        int second=memoization(cost,1,dp);
        return Math.min(first,second);
    }
}