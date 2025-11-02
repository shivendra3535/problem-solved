class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int a: nums){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }
            else{
                map.put(a, 1);
            }
        }

        for(int a: map.keySet()){
            if(map.get(a)==1){
                return a;
            }
        }
      return -1;
    }
}