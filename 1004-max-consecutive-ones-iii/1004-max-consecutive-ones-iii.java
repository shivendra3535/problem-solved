class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int cnt=0;
        int maxLen=Integer.MIN_VALUE;
        while(right<nums.length){
            if(nums[right]==1) cnt++;
            int len=right-left+1;
             while ((right - left + 1) - cnt > k) {
                if (nums[left] == 1) {
                    cnt--;
                }
                left++;
                len=right-left+1;
            }
            maxLen=Math.max(maxLen,len);
            right++;
        }
        return maxLen;
    }
}