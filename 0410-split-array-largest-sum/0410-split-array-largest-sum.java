class Solution {
    public static boolean isPossible(int arr[], int mid, int k){
        int currentSum=0;
        int subarrayCount=1;
        for(int sum: arr){
            if(sum > mid) return false;
            if(currentSum+sum <= mid){
                currentSum+=sum;
            }
            else{
                subarrayCount++;
                currentSum=sum;
                if(subarrayCount>k)return false;
            }
        }
        return true;
    }
    public int splitArray(int[] arr, int k) {
        int max= Integer.MIN_VALUE;
        int sum=0;
        for(int i: arr){
            max=Math.max(max, i);
            sum=sum+i;
        }
        int low=max;
        int high=sum;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(arr, mid , k)){
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