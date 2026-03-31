class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int maxFreq=0;
        int cnt=0;
        for(int k: map.keySet()){
            if(map.get(k)>maxFreq){
                maxFreq=map.get(k);
                cnt=maxFreq;
            }
            else if(map.get(k)==maxFreq){
                cnt+=maxFreq;
            }
        }
        return cnt;
    }
}