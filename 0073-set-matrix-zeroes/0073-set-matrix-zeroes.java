class Solution {
    public void setZeroes(int[][] matrix) {
         ArrayList<Integer>rows_0= new ArrayList<Integer>();
        ArrayList<Integer>cols_0= new ArrayList<Integer>();
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m; i++)
        {
            for(int j=0;j<n; j++)
            {
                if(matrix[i][j]==0)
                {
                    rows_0.add(i);
                    cols_0.add(j);
                }
            }
        }
        for(int i=0; i<rows_0.size();i++)
        {
            int a=rows_0.get(i);
            int b=cols_0.get(i);
            for(int k=0; k<n;k++)
            {
                matrix[a][k]=0;
            }
             for(int l=0; l<m;l++)
            {
                matrix[l][b]=0;
            }
        }

    }
}