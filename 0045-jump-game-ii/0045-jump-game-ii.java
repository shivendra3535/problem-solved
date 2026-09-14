class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1) return 0;
        int cnt=0;
        int maxReach=0;
        int lastStep=0;
        for(int i=0; i<nums.length; i++){
            maxReach=Math.max(maxReach,i+nums[i]);
            if(lastStep==i){
                cnt++;
                lastStep=maxReach;
                if(maxReach>=nums.length-1) return cnt;
            }
        }
        return cnt;
    }
}