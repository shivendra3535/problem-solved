class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int n: nums){
            sum+=n;
        }
        int prefix=0;
        for(int i=0; i<nums.length; i++){
            if(prefix==(sum-prefix-nums[i])) return i;
            prefix+=nums[i];
        }
        return -1;
    }
}