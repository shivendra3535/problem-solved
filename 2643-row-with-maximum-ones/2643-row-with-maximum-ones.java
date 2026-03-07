class Solution {
    public int lowerBound(int arr[]){
        Arrays.sort(arr);
        int low=0;
        int high=arr.length-1;
        int lb=arr.length;
        while(low<=high){
            int mid=(low+high)>>1;
            if(arr[mid]>=1){
                lb=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return lb;
    }
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxRow=0;
        int maxCnt=0;
        for(int i=0; i<mat.length; i++){
            int lb=lowerBound(mat[i]);
            int cnt=mat[0].length-lb;
            if(maxCnt<cnt){
                maxRow=i;
                maxCnt=cnt;
            }
        }
        return new int[]{maxRow,maxCnt};
    }
}