class Solution {
    public int atmostK(int []nums, int k){
        HashMap<Integer,Integer> map= new HashMap<>();
        int left=0;
        int cnt=0;
        for(int right=0; right<nums.length; right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(left<=right && map.size()>k){
                if(map.get(nums[left])==1) map.remove(nums[left]);
                else map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            cnt+=right-left+1;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostK(nums,k)-atmostK(nums,k-1);
    }
}