class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int minLen=Integer.MAX_VALUE;
        String minStr="";
        int freq1[]=new int[128];
        int freq2[]= new int[128];
        for(char c: t.toCharArray()){
            freq1[c]++;
        }
        int required=0;
        for(int i=0; i<128; i++){
            if(freq1[i]>0) required++;
        }
        int curr=0;
        int left=0;
        for(int right=0; right<s.length(); right++){
            freq2[s.charAt(right)]++;
            if(freq2[s.charAt(right)]==freq1[s.charAt(right)]) curr++;
            while(left<=right && curr==required){
                if(minLen>right-left+1){
                    minLen=right-left+1;
                    minStr=s.substring(left,right+1);
                }
                if(freq2[s.charAt(left)]==freq1[s.charAt(left)]) curr--;
                freq2[s.charAt(left)]--;
                left++;
            }
        }
        return minStr;
    }
}