class Solution {
    public int[] runningSum(int[] nums) {
        int prefix[]= new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i>0) prefix[i]=prefix[i-1]+nums[i];
            else prefix[i]=nums[i];
        }
        return prefix;
    }
}