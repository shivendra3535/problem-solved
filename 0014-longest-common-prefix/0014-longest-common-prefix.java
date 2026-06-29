class Solution {
    public String longestCommonPrefix(String[] strs) {
        int wordLen=strs[0].length();
        String word=strs[0];
        for(int i=0; i<wordLen; i++){
            char c=word.charAt(i);
            for(int j=1; j<strs.length; j++){
                String word2=strs[j];
                if(i>=word2.length() || word2.charAt(i)!=c){
                    return word.substring(0,i);
                }
            }
        }
        return word;
    }
}