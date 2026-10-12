class Solution {
    public int maxGain(int prices[], int ind, int buy, int dp[][], int fee){
        if(ind>=prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1){
            int take=-1*prices[ind]+maxGain(prices,ind+1,0,dp,fee);
            int notTake=maxGain(prices,ind+1,1,dp,fee);
            return dp[ind][buy]=Math.max(take,notTake);
        }
        else{
            int sell=prices[ind]-fee+maxGain(prices,ind+1,1,dp,fee);
            int notSell=maxGain(prices,ind+1,0,dp,fee);
            return dp[ind][buy]=Math.max(sell,notSell);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][]= new int[prices.length][2];
        for(int i=0; i<prices.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return maxGain(prices,0,1,dp,fee);
    }
}