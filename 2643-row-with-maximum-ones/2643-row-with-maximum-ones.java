class Solution {
    public int lowerBound(int [] mat){
        int low=0;
        int high=mat.length-1;
        int ans=mat.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mat[mid]>=1){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxCnt=0;
        int index=0;
        for(int i=0; i<mat.length; i++){
            Arrays.sort(mat[i]);
            int lb=lowerBound(mat[i]);
            int cnt=mat[0].length-lb;
            if(maxCnt<cnt){
                maxCnt=cnt;
                index=i;
            }
        }
        return new int[]{index,maxCnt};
    }
}