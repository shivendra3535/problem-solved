class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;
        int len=needle.length();
        char c=needle.charAt(0);
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            if(haystack.charAt(i)==c && haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}