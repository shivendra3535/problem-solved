class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0) return false;
        int n=matrix[0].length;
        if(n==0) return false;
        int left=0;
        int right=(m*n)-1;
        while(left<=right){
            int mid=(left+right)/2;
            int row=mid/n;
            int col=mid%n;
            int val=matrix[row][col];
            if(val==target) return true;
            else if(val>target) right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}