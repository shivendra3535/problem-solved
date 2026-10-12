class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int s: stones){
            sum+=s;
        }
        boolean dp[]= new boolean[sum+1];
        dp[0]=true;
        for(int i=0; i<n; i++){
            boolean tmpDp[]= new boolean[sum+1];
            tmpDp[0]=true;
            for(int s=1; s<=sum; s++){
                boolean notTake=dp[s];
                boolean take=false;
                if(stones[i]<=s){
                    take=dp[s-stones[i]];
                }
                tmpDp[s]=take||notTake;
            }
            dp=tmpDp;
        }
        int min=Integer.MAX_VALUE;
        for(int s1=0; s1<=sum/2; s1++){
            if(dp[s1]){
                int s2=sum-s1;
                min=Math.min(min,Math.abs(s2-s1));
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}