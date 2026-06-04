class Solution {
    public boolean isPossible(int[] weights, int days, int cap){
        int cntWt=0;
        int cntDays=1;
        for(int wt: weights){
            if(cntWt+wt<=cap){
                cntWt+=wt;
            }
            else{
                cntWt=wt;
                cntDays++;
                if(cntDays>days) return false;
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
            int mid=low+ (high-low)/2;
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