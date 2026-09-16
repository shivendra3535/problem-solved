class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        HashMap<Character, Integer> map= new HashMap<>();
        int maxLen=0;
        for(int right=0; right<s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(left,map.get(s.charAt(right))+1);
            }
            maxLen=Math.max(right-left+1,maxLen);
            map.put(s.charAt(right),right);
        }
        return maxLen;
    }
}