class Solution {
    public boolean isPossible(int piles[], int h, int k){
        long cnt=0;
        for(int p: piles){
            cnt+=(p+k-1)/k;
        }
        return cnt<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=Integer.MIN_VALUE;
        for(int p: piles) r=Math.max(r,p);
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(piles,h,mid)){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}