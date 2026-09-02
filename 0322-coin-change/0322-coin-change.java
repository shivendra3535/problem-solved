class Solution {
    public int coinCnt(int coins[], int amount, int index, int dp[][]){ 
        if(amount==0) return 0;
        if(index<0) return (int)1e8;
        if(dp[index][amount]!=-1) return dp[index][amount];
        int pick=Integer.MAX_VALUE;
        if(coins[index]<=amount){
         pick=1+coinCnt(coins,amount-coins[index],index,dp);
        }
        int notPick=coinCnt(coins,amount,index-1,dp);
        dp[index][amount]=Math.min(pick,notPick);
        return dp[index][amount];
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[][]= new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++){
            Arrays.fill(dp[i],-1);
        }
        int res=coinCnt(coins,amount,coins.length-1,dp);
        return res == 100000000 ? -1 : res;
    }
}