class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFreq= new HashMap<>();
        prefixFreq.put(0,1);
        int sum=0;
        int count=0;
        for(int num: nums){
            sum+=num;
            if(prefixFreq.containsKey(sum-k)){
                count+= prefixFreq.get(sum-k);
            }
            prefixFreq.put(sum, prefixFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}