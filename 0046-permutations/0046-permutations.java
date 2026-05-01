class Solution {
    public void swap(int nums[], int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void permutation(int nums[],int index,List<List<Integer>> res){
        if(index>=nums.length){
            List<Integer> ds= new ArrayList<>();
            for(int n: nums){
                ds.add(n);
            }
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index; i<nums.length; i++){
            swap(nums,index,i);
            permutation(nums,index+1,res);
            swap(nums,index,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        permutation(nums,0,res);
        return res;
    }
}