class Solution {
    public String minWindow(String s, String t) {
        int l1=s.length();
        int l2=t.length();
        if(l1<l2) return "";
        int freq1[]=new int[126];
        int freq2[]=new int[126];
        for(int i=0; i<l2; i++){
            freq1[t.charAt(i)]++;
        }
        int required=0;
        for(int i=0; i<126; i++){
            if(freq1[i]>0) required++;
        }
        int minLen=Integer.MAX_VALUE;
        String minStr="";
        int left=0;
        int curr=0;
        for(int right=0; right<l1; right++){
            freq2[s.charAt(right)]++;
            if(freq2[s.charAt(right)]==freq1[s.charAt(right)]) curr++;
            while(left<=right && curr==required){
                if(right-left+1<minLen){
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