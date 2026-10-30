class Solution {
    public String minWindow(String s2, String s1) {
        if(s1.length()>s2.length()) return "";
        int freq1[]= new int[128];
        int freq2[]= new int[128];
        for(char c: s1.toCharArray()){
            freq1[c]++;
        }
        int req=0;
        for(int i=0; i<128; i++){
            if(freq1[i]>0) req++;
        }
        int cur=0;
        int right=0;
        int left=0;
        int minLen = Integer.MAX_VALUE;
        String min = "";
        while(right<s2.length()){
            int idR=s2.charAt(right);
            freq2[idR]++;
            if(freq1[idR]==freq2[idR]) cur++;
            while(left<=right && cur==req){
                if(minLen>right-left+1){
                    minLen=right-left+1;
                    min=s2.substring(left,right+1);
                }
                int idL=s2.charAt(left);
                if(freq1[idL]==freq2[idL]) cur--;
                freq2[idL]--;
                left++;
            }
            right++;
        }
        return min;
    }
}