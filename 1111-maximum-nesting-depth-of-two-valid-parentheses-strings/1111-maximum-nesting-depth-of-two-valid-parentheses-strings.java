class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int currDepth=0;
        int n=seq.length();
        int ans[]= new int[n];
        for(int i=0; i<n; i++){
            char c=seq.charAt(i);
            if(c=='('){
                currDepth++;
                ans[i]=currDepth%2;
            }
            else {
                ans[i]=currDepth%2;
                currDepth--;
            }
        }
        return ans;
    }
}