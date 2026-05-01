class Solution {
    public void sum(int []candidates, int index,int target, List<List<Integer>> res, List<Integer> ds){
        if(index>=candidates.length){
            if(target==0) res.add(new ArrayList<>(ds));
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(target<0) return;
        ds.add(candidates[index]);
        sum(candidates,index,target-candidates[index],res,ds);
        ds.remove(ds.size()-1);
        sum(candidates,index+1,target,res,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        sum(candidates,0,target,res,ds);
        return res;
    }
}