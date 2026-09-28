class Solution {
    public static boolean isPredecessor(String str1, String str2) {
        if (str2 == null || str1 == null || str2.length() != str1.length() + 1) {
            return false;
        }
        int i = 0; 
        int j = 0; 
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str1.length();
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int dp[][]= new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int prev=0; prev<=n; prev++){
                int notTake=dp[i-1][prev];
                int take=0;
                if(prev==n || isPredecessor(words[i-1],words[prev])){
                    take=1+dp[i-1][i-1];
                }
                dp[i][prev]=Math.max(take,notTake);
            }
        }
        return dp[n][n];
    }
}