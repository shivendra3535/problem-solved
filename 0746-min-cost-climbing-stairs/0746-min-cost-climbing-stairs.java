class Solution {
    public int memoization(int []cost, int index, int dp[]){
        if(index>=cost.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int first=cost[index]+memoization(cost,index+1,dp);
        int second=cost[index]+memoization(cost,index+2,dp);
        dp[index]=Math.min(first,second);
        return dp[index];
    }
    public int tabulation(int cost[], int index){
        int dp[]= new int[cost.length];
        for(int i=cost.length-1; i>=index; i--){
            int first=cost[i]+ (i+1>=cost.length?0:dp[i+1]);
            int second=cost[i]+ (i+2>=cost.length?0:dp[i+2]);
            dp[i]=Math.min(first,second);
        }
        return dp[index];
    }

    public int spaceOpt(int cost[],int index){
        int next2=0;
        int next1=0;
        for(int i=cost.length-1; i>=index; i--){
            int first=cost[i]+ next2;
            int second=cost[i]+ next1;
            int current=Math.min(first,second);
            next2=next1;
            next1=current;
        }
        return next1;
    }
    public int minCostClimbingStairs(int[] cost) {
        /* Memoization
        int dp[]= new int[cost.length];
        Arrays.fill(dp,-1);
        int first=memoization(cost,0,dp);
        int second=memoization(cost,1,dp);
        return Math.min(first,second); */

        /*Tabulation
        return Math.min(tabulation(cost,0),tabulation(cost,1)); */

        return Math.min(spaceOpt(cost,0),spaceOpt(cost,1));
    }
}