class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        HashMap<String, List<String>> map= new HashMap<>();
        for(String s: strs){
            char arr[]= s.toCharArray();
            Arrays.sort(arr);
            String sorted= new String(arr);
            if(!map.containsKey(sorted)) map.put(sorted,new ArrayList<>());
            map.get(sorted).add(s);
        }
        for(List<String> ls: map.values()){
            res.add(ls);
        }
        return res;
    }
}