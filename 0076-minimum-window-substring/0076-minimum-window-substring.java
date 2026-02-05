class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        String min="";
        int minLen=Integer.MAX_VALUE;
        int freq1[]= new int[128];
        int freq2[]= new int[128];
        for(char c: t.toCharArray()){
            freq1[c]++;
        }
        int curMatch=0;
        int required=0;
        for(int i=0; i<128; i++){
            if(freq1[i]>0) required++;
        }
        int left=0;
        int right=0;
        while(right<s.length()){
            freq2[s.charAt(right)]++;
            if(freq2[s.charAt(right)]==freq1[s.charAt(right)]) curMatch++;
            while(left<=right && curMatch==required){
                if(minLen>right-left+1){
                    minLen=right-left+1;
                    min=s.substring(left,right+1);
                }
                if(freq2[s.charAt(left)]==freq1[s.charAt(left)]) curMatch--;
                freq2[s.charAt(left)]--;
                left++;           
            }
            right++;
        }
        return min;
    }
}