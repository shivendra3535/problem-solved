class Solution {
    public void combinationSum(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> ds,int curr){
        if(curr==target){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(index==candidates.length || curr>target) return;
        ds.add(candidates[index]);
        combinationSum(candidates, target,index,res,ds,curr+candidates[index]);
        ds.remove(ds.size()-1);
        combinationSum(candidates, target,index+1,res,ds,curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        combinationSum(candidates, target,0,res,ds,0);
        return res;
    }
}