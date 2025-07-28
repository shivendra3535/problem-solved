class Solution {
    public static boolean isPossible(int []piles, int mid, int h){
        int cnt=0;
        for(int pile: piles){
            cnt += (pile + mid - 1) / mid;
            if (cnt > h) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        Arrays.sort(piles);
        int low=1;
        int high=piles[n-1];
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
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