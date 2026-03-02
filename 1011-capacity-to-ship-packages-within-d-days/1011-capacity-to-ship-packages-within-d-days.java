class Solution {
    public boolean isPossible(int weights[], int days, int mid){
        int cnt=1;
        int curWt=0;
        for(int wt: weights){
            if(curWt+wt<=mid){
                curWt+=wt;
            }
            else{
                cnt++;
                curWt=wt;
                if(cnt>days) return false;
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int wt: weights){
            high+=wt;
            low=Math.max(low,wt);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(isPossible(weights,days,mid)){
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