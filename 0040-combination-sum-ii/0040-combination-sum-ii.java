class Solution {
    public void combination(int []candidates,List<Integer> ds, List<List<Integer>> res, int index, int target){
        if(target==0) res.add(new ArrayList<>(ds));
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            ds.add(candidates[i]);
            combination(candidates,ds,res,i+1,target-candidates[i]);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> ds= new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();
        combination(candidates,ds,res,0,target);
        return res;
    }
}