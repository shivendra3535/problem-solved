class Solution {
    public boolean isPossible(int nums[],int threshold, int mid){
        long sum=0;
        for(int n: nums){
            sum+=(n+mid-1)/mid;
        }
        return sum<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=nums[0];
        int ans=-1;
        for(int n: nums) high=Math.max(n,high);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(nums,threshold,mid)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}