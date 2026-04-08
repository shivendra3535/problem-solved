class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n<m) return "";
        int freq1[]= new int[126];
        int freq2[]= new int[126];
        for(char c: t.toCharArray()){
            freq1[c]++;
        }
        int req=0;
        for(int i=0; i<126; i++){
            if(freq1[i]>0) req++;
        }
        int cur=0;
        int right=0;
        int left=0;
        int minLen=Integer.MAX_VALUE;
        String min="";
        while(right<n){
            freq2[s.charAt(right)]++;
            if(freq1[s.charAt(right)]==freq2[s.charAt(right)]) cur++;
            while(left<=right && cur==req){
                int len=right-left+1;
                if(minLen>len){
                    minLen=len;
                    min=s.substring(left,right+1);
                }
                if(freq1[s.charAt(left)]==freq2[s.charAt(left)]) cur--;
                freq2[s.charAt(left)]--;
                left++;
            }
            right++;
        }
        return min;
    }
}