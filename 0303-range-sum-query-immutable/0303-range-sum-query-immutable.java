class NumArray {
    int prefix[];
    public NumArray(int[] nums) {
        prefix=new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i>0) prefix[i]=prefix[i-1]+nums[i];
            else prefix[i]=nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left>0) return prefix[right]-prefix[left-1];
        else return prefix[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */