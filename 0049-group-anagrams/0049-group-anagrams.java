class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map= new HashMap<>();
        List<List<String>> res= new ArrayList<>();
        for(String s: strs){
            char []ch= s.toCharArray();
            Arrays.sort(ch);
            String rev= new String(ch);
            if(!map.containsKey(rev)){
                map.put(rev,new ArrayList<>());
            }
            map.get(rev).add(s);
        }
        for(List<String> s: map.values()){
            res.add(s);
        }
        return res;
    }
}