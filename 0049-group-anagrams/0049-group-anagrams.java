class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        HashMap<String,List<String>> map= new HashMap<>();
        for(String s: strs){
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            String srt=new String(ch);
            if(!map.containsKey(srt)) map.put(srt,new ArrayList<>());
            map.get(srt).add(s);
        }
        for(List<String> ds: map.values()){
            res.add(ds);
        }
        return res;
    }
}