class Solution {
    public void combinationSum3(int k, int n, int index,int cnt, List<Integer> ds, List<List<Integer>> res, int sum) {
        if(cnt==k){
            if(sum==n){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(index>=9) return;
        ds.add(index+1);
        combinationSum3(k,n,index+1,cnt+1,ds,res,sum+index+1);
        ds.remove(ds.size()-1);
        combinationSum3(k,n,index+1,cnt,ds,res,sum);
        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ds= new ArrayList<>();
        List<List<Integer>> res= new ArrayList<>();
        combinationSum3(k,n,0,0,ds,res,0);
        return res;
    }
}