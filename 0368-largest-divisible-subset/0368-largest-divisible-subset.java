class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res= new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        int dp[][]= new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int prev=0; prev<=n; prev++){
                int notTake=dp[i-1][prev];
                int take=0;
                if(prev==n || nums[prev]%nums[i-1]==0){
                    take=1+dp[i-1][i-1];
                }
                dp[i][prev]=Math.max(take,notTake);
            }
        }
        int i=n;
        int prev=n;
        while(i>0){
            if(dp[i][prev]==dp[i-1][prev]){
                i--;
            }
            else{
                res.add(nums[i-1]);
                prev=i-1;
                i--;
            }
        }
        Collections.reverse(res);
        return res;
    }
}