class Solution {
    public int maxGain(int prices[], int index, int buy, int transLeft, int dp[][][]){
        if(index>=prices.length || transLeft==0) return 0;
        int take=0;
        int notTake=0;
        if(dp[index][buy][transLeft]!=-1) return dp[index][buy][transLeft];
        if(buy==1){
            take=-prices[index]+maxGain(prices,index+1,0,transLeft,dp);
            notTake=maxGain(prices,index+1,1,transLeft,dp);
        }
        else{
            take=prices[index]+maxGain(prices,index+1,1,transLeft-1,dp);
            notTake=maxGain(prices,index+1,0,transLeft,dp);
        }
        return dp[index][buy][transLeft]=Math.max(take,notTake);
    }
    public int maxProfit(int k, int[] prices) {
        int dp[][][]= new int[prices.length][2][k+1];
        for(int d[][]:dp){
            for(int arr[]: d){
                Arrays.fill(arr,-1);
            }
        }
        return maxGain(prices,0,1,k,dp);
    }
}