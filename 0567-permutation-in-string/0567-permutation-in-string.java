class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m) return false;
        int freq1[]= new int[26];
        int freq2[]= new int[26];
        for(char c: s1.toCharArray()){
            freq1[c-'a']++;
        }
        int required=0;
        for(int i=0; i<26; i++){
            if(freq1[i]>0) required++;
        }
        int right=0;
        int left=0;
        int curMatch=0;
        while(right<n){
            freq2[s2.charAt(right)-'a']++;
            if(freq2[s2.charAt(right)-'a']==freq1[s2.charAt(right)-'a']) curMatch++;
            right++;
        }
        if(curMatch==required) return true;
        while(right<m){
            int index=s2.charAt(right)-'a';
            freq2[index]++;
            if(freq2[index]==freq1[index]) curMatch++;
            int index1=s2.charAt(left)-'a';
            if(freq1[index1]==freq2[index1]) curMatch--;
            freq2[index1]--;
            if(curMatch==required) return true;
            right++;
            left++;
        }
        return false;
    }
}