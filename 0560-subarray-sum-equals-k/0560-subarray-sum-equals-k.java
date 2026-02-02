class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefix= new HashMap<>();
        prefix.put(0,1);
        int cnt=0;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(prefix.containsKey(sum-k)){
                cnt+=prefix.get(sum-k);
            }
            prefix.put(sum,prefix.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}