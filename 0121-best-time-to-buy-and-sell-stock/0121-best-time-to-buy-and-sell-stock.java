class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)
        {
            return 0;
        }
        int res=prices[1]-prices[0];
        int min=prices[0];
        for(int j=1; j<prices.length; j++)
        {
            res= Math.max(res,prices[j]-min);
            min= Math.min(min,prices[j]);
        }
        if(res<0)
        {
            return 0;
        }
        return res;
    }
}