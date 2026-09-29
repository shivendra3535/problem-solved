class Solution {
    public boolean wordBreakHelper(int index,String s,List<String> wordDict, Boolean dp[]){
        if(index==s.length()) return true;
        if (dp[index] != null) return dp[index];
        for(int i=index; i<s.length(); i++){
            String current=s.substring(index,i+1);
            if(wordDict.contains(current)){
                if(wordBreakHelper(i+1,s,wordDict,dp)) return dp[index]= true;
            }
        }
        return dp[index]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return wordBreakHelper(0,s,wordDict,dp);
    }
}