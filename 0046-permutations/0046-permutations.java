class Solution {
    public void swap(int a, int b,int nums[]){
        int c= nums[a];
        nums[a]=nums[b];
        nums[b]=c;
    }
    private void recurPermute(int index, int[] nums, List < List < Integer >> ans){
        if(index==nums.length){
            List<Integer> ds= new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        for(int i=index; i<nums.length; i++){
            swap(i,index,nums);
            recurPermute(index+1,nums,ans);
            swap(i,index, nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        recurPermute(0,nums,ans);
        return ans;
    }
}