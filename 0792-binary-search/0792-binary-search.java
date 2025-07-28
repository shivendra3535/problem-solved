class Solution {
    public int search1(int low, int high, int[] nums, int target){
        if(low > high){
            return -1;
        }
        int mid=(low+high)/2;
        if(nums[mid] == target){
            return mid;    
        }
        else if(target > nums[mid]){
            return search1(mid+1, high , nums , target);
        }
        else{
            return search1(low, mid-1, nums, target);
        }
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        return search1(low, high, nums, target);
    }
}