class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();
        for(String s: strs){
            char arr[]=s.toCharArray();
            Arrays.sort(arr);
            String sorted=new String(arr);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted ).add(s);
        }
        List<List<String>> res= new ArrayList<>();
        for(List<String> ds: map.values()){
            res.add(ds);
        }
        return res;
    }
}