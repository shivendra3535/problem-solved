class Solution {
    public boolean canJump(int[] nums) {
        int maxFind=0;
        int n= nums.length;
        for(int i=0; i<n; i++){
            if(i>maxFind) return false;
            maxFind=Math.max(maxFind,i+nums[i]);
        }
        return true;
    }
}