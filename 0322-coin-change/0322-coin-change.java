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
    public int tabulation(int []coins, int amount, int n){
        int dp[][]= new int[n][amount+1];
        dp[0][0]=1;
        for(int i=1; i<n; i++){
            dp[i][0]=0;
        }
        for(int amt=0; amt<=amount; amt++){
            if(amt%coins[0]==0){
                dp[0][amt]=amt/coins[0];
            }
            else{
                dp[0][amt]=Integer.MAX_VALUE;
            }
        }
        for(int i=1; i<n; i++){
            for(int amt=0; i<amount+1; amt++){
                int pick=Integer.MAX_VALUE;
                int notPick=Integer.MAX_VALUE;
                if(coins[i]<=amt ){
                    pick=1+dp[i][amt-coins[i]];
                }
                
                notPick=dp[i-1][amt];
                dp[i][amt]=Math.min(pick,notPick);
            }
        }
        return dp[n-1][amount]!=Integer.MAX_VALUE?dp[n-1][amount]:-1;
    }
    public int spaceOpt(int[] coins, int amount, int n) {

    int INF = (int) 1e8;

    int[] prevDp = new int[amount + 1];

    for (int amt = 0; amt <= amount; amt++) {
        if (amt % coins[0] == 0) {
            prevDp[amt] = amt / coins[0];
        } else {
            prevDp[amt] = INF;
        }
    }

    for (int i = 1; i < n; i++) {

        int[] tempDp = new int[amount + 1];

        for (int amt = 0; amt <= amount; amt++) {

            int notPick = prevDp[amt];

            int pick = INF;

            if (coins[i] <= amt) {
                pick = 1 + tempDp[amt - coins[i]];
            }

            tempDp[amt] = Math.min(pick, notPick);
        }

        prevDp = tempDp;
    }

    return prevDp[amount] >= INF ? -1 : prevDp[amount];
}
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        /*int dp[][]= new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++){
            Arrays.fill(dp[i],-1);
        }
        int res=coinCnt(coins,amount,coins.length-1,dp);
        return res == 100000000 ? -1 : res;*/
        //return tabulation(coins,amount,coins.length);
        return spaceOpt(coins,amount,coins.length);
    }
}