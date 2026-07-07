class Solution {
    public int mySqrt(int x) {
        int low=1;
        int high=x/2;
        int sqr=x;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((long)mid*mid==x) return mid;
            else if((long)mid*mid<x){
                sqr=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return sqr;
    }
}