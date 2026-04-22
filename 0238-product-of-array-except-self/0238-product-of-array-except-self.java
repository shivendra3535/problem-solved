class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix=1;
        int suffix=1;
        int ans[]= new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i]=prefix;
            prefix*=nums[i];
        }
        for(int j=nums.length-1; j>=0; j--){
            ans[j]*=suffix;
            suffix*=nums[j];
        }
        return ans;
    }
}