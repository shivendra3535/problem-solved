class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int cnt=0;
        int maxJump=0;
        int lastJump=0;
        for(int i=0; i<nums.length-1; i++){
            maxJump=Math.max(maxJump,nums[i]+i);
            if(i==lastJump){
                lastJump=maxJump;
                cnt++;
                if(maxJump>=nums.length-1) return cnt;
            }
        }
        return cnt;
    }
}