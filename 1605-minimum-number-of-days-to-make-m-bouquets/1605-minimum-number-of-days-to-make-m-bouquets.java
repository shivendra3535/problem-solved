class Solution {
    public static boolean isPossible(int[] bloomDay,int day, int m, int k ){
        int countFlwr=0;
        int countBqt=0;
        for(int b:bloomDay){
            if(b<=day){
                countFlwr++;
                if(countFlwr==k){
                    countBqt++;
                    countFlwr=0;
                }
            }
            else{
                countFlwr=0;
            }
        }
        return (countBqt >= m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min=-1;
        int max= Integer.MIN_VALUE;
        for(int b: bloomDay){
            min=Math.min(min,b);
            max=Math.max(max,b);
        }
        int low=min;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(bloomDay,mid,m,k)){
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