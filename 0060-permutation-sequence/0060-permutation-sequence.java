class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> res= new ArrayList<>();
        for(int i=1; i<n; i++){
            fact = fact*i;
            res.add(i);
        }
        String ans="";
        k=k-1;
        res.add(n);
        while(true){
            ans = ans+res.get(k / fact);
            res.remove(k / fact);
            if(res.size() == 0)break;
            k = k % fact;
            fact = fact/res.size();
        }
        return ans;
    }
}