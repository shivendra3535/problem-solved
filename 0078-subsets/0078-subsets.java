class Solution {
    public void subset(int nums[], int index, List<List<Integer>> res, List<Integer> ds){
        if(index>=nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        subset(nums,index+1,res,ds);
        ds.remove(ds.size()-1);
        subset(nums,index+1,res,ds);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ds= new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();
        subset(nums,0,res,ds);
        return res;
    }
}