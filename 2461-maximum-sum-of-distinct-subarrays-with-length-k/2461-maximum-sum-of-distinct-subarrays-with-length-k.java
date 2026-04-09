class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int right=0;
        int left=0;
        long sum=0;
        long max=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(right<k){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            right++;
        }
        if(map.size()==k) max=Math.max(max,sum);
        while(right<nums.length){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            map.put(nums[left],map.get(nums[left])-1);
            if(map.get(nums[left])==0) map.remove(nums[left]);
            sum-=nums[left];
            if(map.size()==k) max=Math.max(max,sum);
            right++;
            left++;
        }
        return max;
    }
}