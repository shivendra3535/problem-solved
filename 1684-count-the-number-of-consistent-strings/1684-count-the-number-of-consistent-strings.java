class Solution {
    public boolean valid(String s, HashSet<Character> set){
        for(char c: s.toCharArray()){
               if(!set.contains(c)) return false;
           }
        return true;
    }
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for(char c: allowed.toCharArray()){
            set.add(c);
        }
        int cnt=0;
        for(String s: words){
           if(valid(s,set)) cnt++;
        }
       return cnt; 
    }
}