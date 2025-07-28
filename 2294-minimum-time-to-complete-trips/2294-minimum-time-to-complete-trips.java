class Solution {
    public boolean isPossible(int[] time, long mid, int totalTrips){
        
        long trips=0;
        for(int t: time){
           trips+=mid/t;
           if(trips>=totalTrips)return true;
        }
        return trips>=totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long low=1;
        long high= (long)1e14;
        long ans=high;
        while(low<=high){
            long mid=(low+high)/2;
            if(isPossible(time,mid,totalTrips)){
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