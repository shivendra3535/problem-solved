class Solution {
    public int[] rearrangeArray(int[] nums) {
        int l=nums.length;
        int temp[]= new int[l];
        int flag=0;
        int index=0;
        for(int n:nums){
           if(n>=0){
            temp[index++]=n;
           }
        }
        int right=index;
        for(int n:nums){
            if(n<0){
                temp[index++]=n;
            }
        }
        int left=0;
        for(int i=0; i<l; i++){
            if(flag==0){
                nums[i]=temp[left++];
                flag=1;
            }
            else{
                nums[i]=temp[right++];
                flag=0;
            }
        }
        return nums;
    }
}