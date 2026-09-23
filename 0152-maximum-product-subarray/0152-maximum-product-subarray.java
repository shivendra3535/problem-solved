class Solution {
    public int maxProduct(int[] nums) {
        
        int prefix=1;
        int suffix=1;

        int max=Integer.MIN_VALUE;
        int j=nums.length-1;
        for(int i=0; i<nums.length; i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=nums[i];
            suffix*=nums[j];
            max=Math.max(max,Math.max(prefix,suffix));
            j--;
        }

        return max;
    }
}