class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int max=0;
        HashMap<Character, Integer> map= new HashMap<>();
        int maxFreq=0;
        for(int right=0; right<s.length(); right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxFreq=Math.max(maxFreq,map.get(s.charAt(right)));
            while(left<=right && (right-left+1)-maxFreq>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            max=Math.max(max, right-left+1);
        }
        return max;
    }
}