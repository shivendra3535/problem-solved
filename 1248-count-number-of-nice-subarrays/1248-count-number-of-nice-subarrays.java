class Solution {
    public int atMost(int nums[], int k){
        int cnt=0;
        int left=0;
        int atMostCnt=0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]%2!=0) cnt++;
            while(left<=right && cnt>k){
                if(nums[left]%2!=0) cnt--;
                left++;
            }
            atMostCnt+=right-left+1;
        }
        return atMostCnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
}