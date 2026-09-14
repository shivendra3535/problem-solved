class Solution {
    public int recur(String word1,String word2,int i1, int i2 ,int dp[][]){
        if(i1<0) return i2+1;
        if(i2<0) return i1+1;

        if(dp[i1][i2]!=-1) return dp[i1][i2];

        if(word1.charAt(i1)==word2.charAt(i2)){
            return dp[i1][i2]=recur(word1,word2,i1-1,i2-1,dp);
        }
        else{
            int insert=1+recur(word1,word2,i1,i2-1,dp);
            int replace=1+recur(word1,word2,i1-1,i2-1,dp);
            int delete=1+recur(word1,word2,i1-1,i2,dp);
            return dp[i1][i2]=Math.min(insert,Math.min(replace,delete));
        }
    }
    public int minDistance(String word1, String word2) {
        int dp[][]= new int[word1.length()][word2.length()];
        for(int i=0; i<word1.length(); i++) Arrays.fill(dp[i],-1);
        return recur(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
}