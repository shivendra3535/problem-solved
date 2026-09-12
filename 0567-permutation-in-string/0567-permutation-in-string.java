class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length();
        int l2=s2.length();
        if(l1>l2) return false;
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
        while(right<l1){
            freq2[s2.charAt(right)-'a']++;
            if(freq1[s2.charAt(right)-'a']==freq2[s2.charAt(right)-'a']) cur++;
            right++;
        }
        if(cur==req) return true;
        while(right<l2){
            freq2[s2.charAt(right)-'a']++;
            if(freq1[s2.charAt(right)-'a']==freq2[s2.charAt(right)-'a']) cur++;
        
            if(freq1[s2.charAt(left)-'a']==freq2[s2.charAt(left)-'a']) cur--;
            freq2[s2.charAt(left)-'a']--;
            if(cur==req) return true;
            right++;
            left++;
        }
        return false;
    }
}