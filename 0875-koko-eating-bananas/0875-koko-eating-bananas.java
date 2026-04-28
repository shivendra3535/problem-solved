class Solution {
    public boolean isPossible(int[] piles, int h, int mid){
        int cnt=0;
        for(int p: piles){
            cnt+=(p+mid-1)/mid;
            if(cnt>h) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        int ans=-1;
        for(int p: piles){
            high=Math.max(high,p);
        }
        while(low<=high){
            int mid=low + (high-low)/2;
            if(isPossible(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}