class Solution {
    public void combinationSum(int[] candidates, int target, List<Integer> ds, List<List<Integer>>res,int index, int curr){
        if(curr==target){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(curr>target || index>=candidates.length) return;
        ds.add(candidates[index]);
        combinationSum(candidates,target,ds,res,index, curr+candidates[index]);
        ds.remove(ds.size()-1);
        combinationSum(candidates,target,ds,res,index+1,curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        combinationSum(candidates,target,ds,res,0,0);
        return res;
    }
}