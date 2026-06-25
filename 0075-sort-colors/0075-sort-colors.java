class Solution {
    public void swap(int nums[], int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int mid=0;
        int left=0;
        int high=nums.length-1;
        while(mid<=high){
            int num=nums[mid];
            if(num==0){
                swap(nums,left,mid);
                left++;
                mid++;
            }
            else if(num==2){
                swap(nums,mid,high);
                high--;
            }
            else{
                mid++;
            }
        }
    }
}