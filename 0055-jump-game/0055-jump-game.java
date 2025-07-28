class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxfind=0;
        for(int i=0; i<n; i++)
        {
            if(i>maxfind) return false;
            maxfind=Math.max(maxfind,i+nums[i]);
        }
        return true;
    }
}