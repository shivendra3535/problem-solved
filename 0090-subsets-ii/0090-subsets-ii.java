class Solution {
    public void subset(int []nums, int index, List<List<Integer>> res, List<Integer> ds){
        res.add(new ArrayList<>(ds));
        
        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i]==nums[i-1]) continue;

            ds.add(nums[i]);
            subset(nums,i+1,res,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        subset(nums,0,res,ds);
        return res;
    }
}