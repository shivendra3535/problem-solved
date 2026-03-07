class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m-1;
        while(left<m && right>=0){
            int mid=(left+right)>>1;
            if(matrix[left][mid]==target) return true;
            else if(matrix[left][mid]>target) right--;
            else left++;
        }
        return false;
    }
}