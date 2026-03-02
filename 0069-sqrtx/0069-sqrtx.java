class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int low=1;
        int high=x/2;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)>>1;
            long sqrt=(long)mid*mid;
            if(sqrt<=x){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}