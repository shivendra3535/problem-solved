class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(char c: s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        ArrayList<Character> arr[]= new ArrayList[s.length()+1];
        for(char c: map.keySet()){
            int freq=map.get(c);
            if(arr[freq]==null) arr[freq]= new ArrayList<>();
            arr[freq].add(c);
        }
        StringBuilder sb= new StringBuilder();
        for(int i=s.length(); i>=1; i--){
            if(arr[i]==null) continue;
            for(char c: arr[i]){
                for(int j=0; j<i; j++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}