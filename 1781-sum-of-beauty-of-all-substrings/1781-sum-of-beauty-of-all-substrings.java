class Solution {
    public int beautySum(String s) {
        int sum=0;
        for(int i=0; i<s.length(); i++){
            HashMap<Character,Integer> map= new HashMap<>();
            for(int j=i; j<s.length(); j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                int minFreq= Integer.MAX_VALUE;
                int maxFreq= Integer.MIN_VALUE;
                for(int freq: map.values()){
                    minFreq=Math.min(minFreq,freq);
                    maxFreq=Math.max(maxFreq,freq);
                }
                sum+=maxFreq-minFreq;
            }
        }
        return sum;
    }
}