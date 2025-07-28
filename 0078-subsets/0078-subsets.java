class Solution {
    public void subsets(int index,List<List<Integer>> res,List<Integer> ds,int[] nums){
        if(index>=nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        subsets(index+1, res, ds, nums);

        ds.remove(ds.size()-1);
        subsets(index+1, res, ds, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds= new ArrayList<Integer>();
        subsets(0,res,ds,nums);
        return res;
    }
}