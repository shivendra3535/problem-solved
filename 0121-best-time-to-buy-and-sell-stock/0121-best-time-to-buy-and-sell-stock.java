class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int minLeft=prices[0];
        int maxProfit=prices[1]-minLeft;
        for(int i=1; i<prices.length; i++){
            maxProfit=Math.max(maxProfit,prices[i]-minLeft);
            minLeft=Math.min(minLeft,prices[i]);
        }
        if(maxProfit<0) return 0;
        return maxProfit;
    }
}