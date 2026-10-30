class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int freq1[]= new int[26];
        int freq2[]= new int[26];
        for(char c: s1.toCharArray()){
            freq1[c-'a']++;
        }
        int req=0;
        for(int i=0; i<26; i++){
            if(freq1[i]>0) req++;
        }
        int cur=0;
        int right=0;
        int left=0;
        while(right<s1.length()){
            int idR=s2.charAt(right)-'a';
            freq2[idR]++;
            if(freq1[idR]==freq2[idR]) cur++;
            right++;
        }
        if(req==cur) return true;
        while(right<s2.length()){
            int idR=s2.charAt(right)-'a';
            freq2[idR]++;
            if(freq1[idR]==freq2[idR]) cur++;

            int idL=s2.charAt(left)-'a';
            if(freq1[idL]==freq2[idL]){
                cur--;
            }
            freq2[idL]--;
            if(req==cur) return true;
            left++;
            right++;
        }
        return false;
    }
}