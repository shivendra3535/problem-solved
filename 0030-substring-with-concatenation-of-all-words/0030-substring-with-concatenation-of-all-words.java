class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res= new ArrayList<>();
        int wordLen=words[0].length();
        int wordReq=words.length;
        HashMap<String, Integer> need= new HashMap<>();
        for(String w: words){
            need.put(w, need.getOrDefault(w,0)+1);
        }
        for(int start=0; start<wordLen; start++){
            HashMap<String, Integer> have= new HashMap<>();
            int left=start;
            int curr=0;
            for(int right=start; right+wordLen<=s.length(); right+=wordLen){
                String word=s.substring(right,right+wordLen);
                if(!need.containsKey(word)){
                    have.clear();
                    curr=0;
                    left=right+wordLen;
                    continue;
                }
                curr++;
                have.put(word, have.getOrDefault(word,0)+1);
                while(left<=right && have.get(word)>need.get(word)){
                    String w=s.substring(left, left+wordLen);
                    have.put(w,have.get(w)-1);
                    curr--;
                    left+=wordLen;
                }
                if(curr==wordReq){
                    res.add(left);
                }
            }
        }
        return res;
    }
}