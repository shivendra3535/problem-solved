class Solution {
    public void combinationSum3(int k, int n, int index,int sum, int cnt,List<Integer> ds, List<List<Integer>> res){
        if(cnt==k){
            if(sum==n){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(index>=9)
        {
            return;
        }
            ds.add(index+1);
            combinationSum3(k,n,index+1,sum+index+1,cnt+1,ds,res);
            ds.remove(ds.size()-1);
        combinationSum3(k,n,index+1,sum,cnt,ds,res);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        combinationSum3(k,n,0,0,0,ds,res);
        return res;
    }
}