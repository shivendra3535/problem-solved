class Solution {
    public int upper(int nums[], int target){
        int ans=nums.length;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>target){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public int lower(int nums[], int target){
        int ans=nums.length;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>=target){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int u=upper(nums,target);
        int l=lower(nums,target);
        if(l==nums.length || nums[l]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{l,u-1};
    }
}