class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefix= new HashMap<>();
        prefix.put(0,1);
        int sum=0;
        int cnt=0;
        for(int n: nums){
            sum+=n;
            if(prefix.containsKey(sum-k)){
                cnt+=prefix.get(sum-k);
            }

            prefix.put(sum,prefix.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}