class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res= new ArrayList<>();
        int wordLen=words[0].length();
        int requiredWords=words.length;
        HashMap<String, Integer> need= new HashMap<>();
        for(String w: words){
            need.put(w,need.getOrDefault(w,0)+1);
        }
        for(int start=0; start<wordLen; start++){
            HashMap<String,Integer> have= new HashMap<>();
            int left=start;
            int curMatch=0;
            for(int right=start; right+wordLen<=s.length(); right=right+wordLen){
                String word=s.substring(right,right+wordLen);
                if(!need.containsKey(word)){
                    have.clear();
                    curMatch=0;
                    left=right+wordLen;
                    continue;
                }
                have.put(word,have.getOrDefault(word,0)+1);
                curMatch++;
                while(left<=right && have.get(word)>need.get(word)){
                    String word2=s.substring(left,left+wordLen);
                    have.put(word2,have.get(word2)-1);
                    curMatch--;
                    left+=wordLen;
                }
                if(curMatch==requiredWords) res.add(left);
            }
        }
        return res;
    }
}