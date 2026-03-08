class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int maxEle=mat[0][mid];
            int row=0;
            for(int i=0; i<m; i++){
                if(maxEle<mat[i][mid]){
                    maxEle=mat[i][mid];
                    row=i;
                }
            }
            int left = (mid > 0) ? mat[row][mid - 1] : -1;
            int right = (mid < n - 1) ? mat[row][mid + 1] : -1;

            if (maxEle > left && maxEle > right) {
                return new int[]{row, mid};
            } else if (left > maxEle) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}