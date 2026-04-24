class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m) return false;
        int freq1[]= new int[26];
        int freq2[]= new int[26];
        for(char c: s.toCharArray()){
            freq1[c-'a']++;
        }
        for(char c: t.toCharArray()){
            freq2[c-'a']++;
        }
        for(char c: t.toCharArray()){
            if(freq1[c-'a']!=freq2[c-'a']) return false;
        }
        return true;
    }
}