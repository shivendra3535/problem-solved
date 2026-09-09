class Solution {
    public int recur(String text1, String text2, int i1, int i2, int dp[][]){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(text1.charAt(i1)==text2.charAt(i2)){
            dp[i1][i2]=1+recur(text1,text2,i1-1,i2-1,dp);
            return dp[i1][i2];
        }
        
        int f1=recur(text1,text2,i1-1,i2,dp);
        int f2=recur(text1,text2,i1,i2-1,dp);
        dp[i1][i2]= Math.max(f1,f2);
        return dp[i1][i2];
    }
    public int tabulation(String text1, String text2){
        int dp[][]= new int[text1.length()+1][text2.length()+1];
        for(int i=1; i<text1.length()+1; i++){
            for(int j=1; j<text2.length()+1; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    int f1=dp[i-1][j];
                    int f2=dp[i][j-1];
                    dp[i][j]=Math.max(f1,f2);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public int spaceOpt(String text1, String text2){
        int prevDp[]= new int[text2.length()+1];
        for(int i=1; i<text1.length()+1; i++){
            int tempDp[]=new int[text2.length()+1];
            for(int j=1; j<text2.length()+1; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    tempDp[j]=1+prevDp[j-1];
                }
                else{
                    int f1=prevDp[j];
                    int f2=tempDp[j-1];
                    tempDp[j]=Math.max(f1,f2);
                }
            }
            prevDp=tempDp;
        }
        return prevDp[text2.length()];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        /*int dp[][]= new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(text1,text2,text1.length()-1,text2.length()-1,dp);*/
        //return tabulation(text1,text2);
        return spaceOpt(text1,text2);
    }
}