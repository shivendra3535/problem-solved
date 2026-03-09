class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)>>1;
            int row=0;
            int maxEle=Integer.MIN_VALUE;
            for(int i=0; i<m; i++){
                if(maxEle<mat[i][mid]){
                    maxEle=mat[i][mid];
                    row=i;
                }
            }
            int left;
            int right;
            if(mid>0){
                left=mat[row][mid-1];
            }
            else{
                left=-1;
            }

            if(mid<n-1){
                right=mat[row][mid+1];
            }
            else{
                right=-1;
            }

            if(maxEle>left && maxEle>right){
                return new int[]{row,mid};
            }
            else if(left>maxEle){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}