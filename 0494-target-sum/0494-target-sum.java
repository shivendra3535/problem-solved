class Solution {
    public int targetSum(int []nums, int target, int index){
        if(index>=nums.length){
            if(target==0) return 1;
            return 0;
        }
        int add=targetSum(nums,target-nums[index], index+1);
        int sub=targetSum(nums,target+nums[index],index+1);
        return add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return targetSum(nums,target,0);
    }
}
