class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();
        for(String s: strs){
            char arr[]=s.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        List<List<String>> res= new ArrayList<>();
        for(List<String> ls: map.values()){
            res.add(ls);
        }
        return res;
    }
}