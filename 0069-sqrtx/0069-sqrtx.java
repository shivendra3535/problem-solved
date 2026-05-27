class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int i=1;
        int j=x/2;
        int sqrt=x;
        while(i<=j){
            int mid=i+ (j-i)/2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            }
            
            if(square<x){
                sqrt=mid;
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return sqrt;
    }
}