class Solution {
    public void combinationSum(int []candidates, int index, List<Integer> ds, int target, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(index==candidates.length || target<0){
            return;
        }

        ds.add(candidates[index]);
        combinationSum(candidates,index,ds,target-candidates[index],res);
        ds.remove(ds.size()-1);
        combinationSum(candidates,index+1,ds,target,res);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        combinationSum(candidates,0,ds,target,res);
        return res;
    }
}