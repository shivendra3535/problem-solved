class Solution {
    public boolean isPossible(int [] weights, int days, int mid){
        int cnt=1;
        int cntWt=weights[0];
        for(int i=1; i<weights.length; i++){
            if(cntWt+weights[i]<=mid){
                cntWt+=weights[i];
            }
            else{
                cnt++;
                cntWt=weights[i];
                if(cnt>days) return false;
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int wt: weights){
            low=Math.max(low,wt);
            high+=wt;
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
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