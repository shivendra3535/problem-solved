class Solution {
    public int recur(String s, String t, int i1, int i2 ,int dp[][]){
        if(i2<0) return 1;
        if(i1<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s.charAt(i1)==t.charAt(i2)){
            return dp[i1][i2]=recur(s,t,i1-1,i2-1,dp)+recur(s,t,i1-1,i2,dp);
        }
        else{
            return dp[i1][i2]=recur(s,t,i1-1,i2,dp);
        }
    }
    public int tabulation(String s, String t){
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            dp[i][0]=1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
    public int numDistinct(String s, String t) {
        int dp[][]= new int[s.length()][t.length()];
        for(int i=0; i<s.length(); i++) Arrays.fill(dp[i],-1);
        //return recur(s,t,s.length()-1,t.length()-1,dp);
        return tabulation(s,t);
    }
}