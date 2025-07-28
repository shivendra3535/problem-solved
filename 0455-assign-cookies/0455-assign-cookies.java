class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int left=0;
        int right=0;
        while(left<m && right<n)
        {
            if(g[right]<=s[left])
            {
                right++;
            }
            left++;
        }
        return right;
    }
}