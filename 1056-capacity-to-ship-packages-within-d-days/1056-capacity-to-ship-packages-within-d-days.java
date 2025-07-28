class Solution {
    public static boolean isPossible(int[] weights,int mid, int days){
        int wCount=0;
        int dayCount=1;
        for(int w: weights){
            if(w>mid)return false;
            if( w+ wCount<=mid){
                wCount+=w;
            }
            else{
                dayCount++;
                wCount=w;
                if(dayCount > days)return false;
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int w: weights){
            sum=sum+w;
            max=Math.max(max,w);
        }
        int low=max;
        int high=sum;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(weights,mid,days)){
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