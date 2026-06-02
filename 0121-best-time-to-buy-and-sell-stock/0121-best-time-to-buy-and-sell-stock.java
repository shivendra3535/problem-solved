class Solution {
    public int maxProfit(int[] prices) {
        int max=Integer.MIN_VALUE;
        int minLeft=prices[0];
        for(int i=1; i<prices.length; i++){
            max=Math.max(max,prices[i]-minLeft);
            minLeft=Math.min(minLeft,prices[i]);
        }
        return (max<=0)? 0: max;
    }
}