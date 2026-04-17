class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct=Integer.MIN_VALUE;
        int prefix=1;
        int suffix=1;
        int j=nums.length;
        for(int i=0; i<nums.length; i++){
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix*=nums[i];
            suffix*=nums[j-1];
            maxProduct=Math.max(maxProduct,prefix);
            maxProduct=Math.max(maxProduct,suffix);
            j--;
        }
        return maxProduct;
    }
}