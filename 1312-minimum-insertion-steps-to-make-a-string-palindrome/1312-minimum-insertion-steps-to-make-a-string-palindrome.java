class Solution {
    public int lcs(String s, String r, int i1, int i2, int dp[][]){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s.charAt(i1)==r.charAt(i2)){
            dp[i1][i2]=1+lcs(s,r,i1-1,i2-1,dp);
            return dp[i1][i2];
        }
        else{
            int f1=lcs(s,r,i1-1,i2,dp);
            int f2=lcs(s,r,i1,i2-1,dp);
            dp[i1][i2]=Math.max(f1,f2);
            return dp[i1][i2];
        }
    }
    public int minInsertions(String s) {
        String r= new StringBuilder(s).reverse().toString();
        int n=s.length();
        int dp[][]= new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        int x= lcs(s,r,n-1,n-1,dp);
        return n-x;
    }
}