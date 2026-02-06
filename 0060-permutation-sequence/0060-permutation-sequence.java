class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> res= new ArrayList<>();
        for(int i=1; i<n; i++){
            fact*=i;
            res.add(i);
        }
        res.add(n);
        String ans="";
        k=k-1;
        while(true){
            ans+=res.get(k/fact);
            res.remove(k/fact);
            if(res.size()==0) break;
            k=k%fact;
            fact=fact/res.size();
        }
        return ans;
    }
}