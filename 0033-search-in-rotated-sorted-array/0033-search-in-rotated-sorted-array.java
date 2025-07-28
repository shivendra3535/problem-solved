class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target)return mid;
            //checking left side if it is sorted or not
            if(nums[low]<=nums[mid]){
                //if left side is sorted, we will check if solution lies in index range low to mid
                if(target >= nums[low] && target<=nums[mid]){
                    //means solution will exist in left side only, no need to check right side
                    high=mid-1;
                }
                else{
                    //if solution not exist in sorted left part , we will move to right side 
                    low= mid+1;
                }
            }
            else{
                //left side is not sorted, means right side is sorted.Check if target lies in index range mid to high
                if(target >= nums[mid] && target <=nums[high]){
                    //means  solution exist in right side ,no need to check left side
                    low=mid+1;
                }
                else{
                    //if solution is not at right side move to left part
                    high= mid-1;
                }
            }
        }
        return -1;
    }
}