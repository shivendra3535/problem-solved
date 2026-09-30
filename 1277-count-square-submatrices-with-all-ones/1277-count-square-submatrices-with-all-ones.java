class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]= new int[m][n];
        int cnt=0;
        for(int i=0; i<n; i++){
            dp[0][i]=matrix[0][i];
            if(dp[0][i]==1) cnt++;
        }
        for(int i=1; i<m; i++){
            dp[i][0]=matrix[i][0];
            if(dp[i][0]==1) cnt++;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==1){
                  int up=dp[i-1][j];
                  int left=dp[i][j-1];
                  int upDiag=dp[i-1][j-1];
                  int ans=Math.min(up,Math.min(left,upDiag));
                  dp[i][j]=1+ans;
                  cnt+=dp[i][j];
                }
            }
        }
        return cnt;
    }
}