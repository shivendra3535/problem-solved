class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n<m) return "";
        String min="";
        int minLen=Integer.MAX_VALUE;
        int right=0;
        int left=0;
        int freq1[]= new int[128];
        int freq2[]= new int[128];
        for(char c: t.toCharArray()){
            freq1[c]++;
        }
        int required=0;
        int curMatch=0;
        for(int i=0; i<128; i++){
            if(freq1[i]>0) required++;
        }
        while(right<n){
            freq2[s.charAt(right)]++;
            if(freq2[s.charAt(right)]==freq1[s.charAt(right)]) curMatch++;
            while(left<=right && curMatch==required){
                int len=right-left+1;
                if(len<minLen){
                    minLen=right-left+1;
                    min=s.substring(left,right+1);
                }
                if(freq1[s.charAt(left)]==freq2[s.charAt(left)]) curMatch--;
                freq2[s.charAt(left)]--;
                left++;
            }
            right++;
        }
        return min;
    }
}