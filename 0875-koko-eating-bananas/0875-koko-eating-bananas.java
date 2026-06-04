class Solution {
    public boolean isPossible(int []piles, int h, int k){
        int cnt=0;
        for(int p: piles){
            cnt+=(p+k-1)/k;
            if(cnt>h) return false;
        }
        return cnt<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MAX_VALUE;
        for(int p: piles){
            high=Math.max(high,p);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+ (high-low)/2;
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