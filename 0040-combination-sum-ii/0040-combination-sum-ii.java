class Solution {
     public void combinationSum2(int index ,ArrayList<Integer> ans,List<List<Integer>> res , int[] candidates, int target) {

        if(target==0){
            res.add(new ArrayList<>(ans));
            return ;
        }

        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            ans.add(candidates[i]);
            combinationSum2(i+1,ans,res,candidates,target-candidates[i]);
            ans.remove(ans.size()-1);
        }
     }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        ArrayList<Integer> ans= new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum2(0,ans,res,candidates,target);
        return res;
    }
}