class Solution {
    public int ncr(int n, int r)
    {
        int res=1;
        for(int i=0; i<r; i++)
        {
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public List<List<Integer>> generate(int numrows) {
        List<List<Integer>> results= new ArrayList<>();
        if(numrows==0)
        {
           return results;
        }
        List<Integer> firstrow = new ArrayList<>();
        firstrow.add(1);
        results.add(firstrow);
        for(int i=2; i<=numrows; i++)
        {
            List<Integer> newrows= new ArrayList<>();
            for(int c=1; c<=i; c++)
            {
                newrows.add(ncr(i-1,c-1));
            }
            results.add(newrows);
        }
        return results;
    }
}