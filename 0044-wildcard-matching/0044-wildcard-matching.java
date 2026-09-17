class Solution {
    public boolean wild(String s, String p, int i, int j, Boolean dp[][]){
        if(i<0 && j<0) return true;
        if(j<0) return false;
        if(i<0){
            for(int k=0; k<=j; k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }
        
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]=wild(s,p,i-1,j-1,dp);
        }
        
        if(p.charAt(j)=='*'){
            return dp[i][j]= wild(s,p,i,j-1,dp) || wild(s,p,i-1,j,dp);
        }

        return dp[i][j]=false;
    }

    public boolean tabulation(String s, String p){
        int n=s.length();
        int m=p.length();
        boolean dp[][]= new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1; i<=n; i++) dp[i][0]=false;
        for(int j=1; j<=m; j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
            else{
                dp[0][j]=false;
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j]= dp[i][j-1] || dp[i-1][j];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    public boolean isMatch(String s, String p) {
        Boolean dp[][]= new Boolean[s.length()][p.length()];
        //return wild(s,p,s.length()-1,p.length()-1,dp);
        return tabulation(s,p);
    }
}