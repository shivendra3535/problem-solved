class Solution {
    public void combination(int []candidates, int target, int index,List<List<Integer>> res, List<Integer> ds){
        if(target==0){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(target<0) break;
            ds.add(candidates[i]);
            combination(candidates,target-candidates[i],i+1,res,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        combination(candidates,target,0,res,ds);
        return res;
    }
}