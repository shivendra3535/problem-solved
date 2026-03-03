class Solution {
    public boolean isPossible(int nums[],int k, int mid){
        int cnt=1;
        int curSum=0;
        for(int num:nums){
            if(curSum+num<=mid){
                curSum+=num;
            }
            else{
                cnt++;
                curSum=num;
                if(cnt>k) return false;
            }
        }
        return cnt<=k;
    }
    public int splitArray(int[] nums, int k) {
        int low= Integer.MIN_VALUE;
        int high=0;
        for(int num: nums){
            low=Math.max(low,num);
            high+=num;
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)>>1;
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