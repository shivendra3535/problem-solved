class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m=g.length;
        int n=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int right=0;
        int left=0;
        while(right<m && left<n){
            if(g[right]<=s[left]) right++;
            left++;
        }
        return right;
    }
}