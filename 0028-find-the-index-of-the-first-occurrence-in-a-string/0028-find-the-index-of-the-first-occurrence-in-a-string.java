class Solution {
    public int strStr(String haystack, String needle) {
        int len=needle.length();
        char c=needle.charAt(0);
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            int j=0;
            while(j<len && haystack.charAt(i+j)==needle.charAt(j)) j++;
            if(j==len) return i;
        }
        return -1;
    }
}