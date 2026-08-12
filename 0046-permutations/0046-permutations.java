class Solution {
    public void swap(int nums[], int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void permute(int nums[], int index, List<List<Integer>> res){
        if(index>=nums.length){
            List<Integer> ds= new ArrayList<>();
            for(int n: nums){
                ds.add(n);
            }
            res.add(ds);
            return ;
        }
        for(int i=index; i<nums.length; i++){
            swap(nums,index,i);
            permute(nums,index+1, res);
            swap(nums,index,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        permute(nums,0,res);
        return res;
    }
}