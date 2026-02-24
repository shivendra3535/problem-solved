class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map= new HashMap<>();
        int left=0;
        int right=0;
        int maxFreq=Integer.MIN_VALUE;
        int maxLen=Integer.MIN_VALUE;
        while(right<s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            maxFreq=Math.max(maxFreq,map.get(s.charAt(right)));
            int len=right-left+1;
            while(left<=right && len-maxFreq>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
                len=right-left+1;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}