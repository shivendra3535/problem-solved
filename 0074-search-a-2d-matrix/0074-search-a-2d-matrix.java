class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int row=0;
        int col=n-1;
        while(row<m && col>=0){
            int mid=(row+col)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]>target) col--;
            else row++;
        }
        return false;
    }
}