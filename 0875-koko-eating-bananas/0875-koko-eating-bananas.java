class Solution {
    public boolean isPossible(int piles[], int k, int h){
        int cnt=0;
        for(int pile:piles){
            cnt+=(pile+k-1)/k;
            if(cnt>h){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low=1;
        int high=piles[piles.length-1];
        int ans=-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(isPossible(piles,mid,h)){
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