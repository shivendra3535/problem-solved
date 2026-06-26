class Solution {
    public String frequencySort(String s) {
        List<Character> freq[]= new ArrayList[s.length()+1];
        for (int i = 0; i <= s.length(); i++) {
           freq[i] = new ArrayList<>();
        }
        HashMap<Character, Integer> map= new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c: map.keySet()){
            int f=map.get(c);
            freq[f].add(c);
        }
        String str="";
        for(int i=s.length(); i>0; i--){
            for(char c: freq[i]){
                for(int j=0; j<i; j++){
                    str+=c;
                }
            }
        }
        return str;
    }
}