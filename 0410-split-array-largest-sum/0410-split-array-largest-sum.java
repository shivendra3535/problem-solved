class Solution {
    public boolean isPossible(int nums[], int k, int sum){
        int cnt=1;
        int curSum=nums[0];
        for(int i=1; i<nums.length; i++){
            if(curSum+nums[i]<=sum){
                curSum+=nums[i];
            }
            else{
                cnt++;
                curSum=nums[i];
                if(cnt>k) return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int n: nums){
            low=Math.max(low,n);
            high+=n;
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}