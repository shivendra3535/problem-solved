class Solution {
    public int recur(int n, int dp[]){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        dp[n]=recur(n-1, dp)+ recur(n-2,dp);
        return dp[n];
    }
    public int tabulation(int n){
        int dp[]= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        //return recur(n,dp);
        return tabulation(n);
    }
}