class Solution {
    public int exactGoal(int nums[],int goal){
        int left=0;
        int cnt=0;
        int sum=0;
        for(int right=0; right<nums.length; right++){
            sum+=nums[right];
            while(left<=right && sum>goal){
                sum-=nums[left];
                left++;
            }
            cnt+=right-left+1;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       return exactGoal(nums,goal)-exactGoal(nums,goal-1);
    }
}