class Solution {
    public boolean isPossible(int []nums, int threshold, int d){
        int sum=0;
        for(int n: nums){
            sum+=(n+d-1)/d;
            if(sum>threshold) return false;
        }
        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int n: nums){
            high=Math.max(high,n);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(isPossible(nums,threshold,mid)){
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