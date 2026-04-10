class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map= new HashMap<>();
        int maxFreq=Integer.MIN_VALUE;
        int maxLen=Integer.MIN_VALUE;
        int left=0;
        for(int right=0; right<s.length(); right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxFreq=Math.max(maxFreq,map.get(s.charAt(right)));
            int len=right-left+1;
            while(left<=right && len-maxFreq>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
                left++;
                len=right-left+1;
            }
            if(right-left+1-maxFreq==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
        }
        return maxLen==Integer.MIN_VALUE ? s.length():maxLen;
    }
}