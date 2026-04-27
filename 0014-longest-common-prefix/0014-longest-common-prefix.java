class Solution {
    public String longestCommonPrefix(String[] strs) {
        int wordLen=strs[0].length();
        String ans=strs[0];
        for(int i=0; i<wordLen; i++){
            char c=strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(i>=strs[j].length() || strs[j].charAt(i)!=c){
                    ans=strs[0].substring(0,i);
                    return ans;
                }
            }
        }
        return ans;
    }
}