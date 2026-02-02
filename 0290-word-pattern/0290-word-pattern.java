class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[]=s.split(" ");
        if(pattern.length()!=arr.length) return false;
        HashMap<Character,String> map1= new HashMap<>();
        HashMap<String,Character> map2= new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char c=pattern.charAt(i);
            String d=arr[i];
            if(!map1.containsKey(c)){
                map1.put(c,d);
            }
            else{
                if(map1.get(c).equals(d)==false) return false;
            }

            if(!map2.containsKey(d)){
                map2.put(d,c);
            }
            else{
                if(map2.get(d)!=c) return false;
            }

        }
        return true;
    }
}