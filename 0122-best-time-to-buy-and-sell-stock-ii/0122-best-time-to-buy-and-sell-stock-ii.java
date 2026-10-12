class Solution {
    public int maxGain(int prices[], int ind, int buy, int dp[][]){
        if(ind>=prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1){
            int take=-1*prices[ind]+maxGain(prices,ind+1,0,dp);
            int notTake=maxGain(prices,ind+1,1,dp);
            return dp[ind][buy]=Math.max(take,notTake);
        }
        else{
            int sell=prices[ind]+maxGain(prices,ind+1,1,dp);
            int notSell=maxGain(prices,ind+1,0,dp);
            return dp[ind][buy]=Math.max(sell,notSell);
        }
    }
    public int tabulation(int prices[]){
        int dp[][]= new int[prices.length+1][2];
        for(int i=prices.length-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                if(buy==1){
                int take=-1*prices[i]+dp[i+1][0];
                int notTake=dp[i+1][1];
                dp[i][buy]=Math.max(take,notTake);
                }
                else{
                int sell=prices[i]+dp[i+1][1];
                int notSell=dp[i+1][0];
                dp[i][buy]=Math.max(sell,notSell);
                }
            }
        }
        return dp[0][1];
    }
    public int maxProfit(int[] prices) {
        int dp[][]= new int[prices.length][2];
        for(int i=0; i<prices.length; i++){
            Arrays.fill(dp[i],-1);
        }
        //return maxGain(prices,0,1,dp);

        return tabulation(prices);
    }
}