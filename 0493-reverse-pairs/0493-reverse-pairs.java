class Solution {
    public void merge(int arr[],int left, int mid, int right){
        List<Integer> temp= new ArrayList<>();
        int l=left;
        int r=mid+1;
        int cnt=0;
        while(l<=mid && r<=right){
            if(arr[l]<=arr[r]){
                temp.add(arr[l]);
                l++;
            }
            else{
                temp.add(arr[r]);
                r++;
            }
        }
        
        while(l<=mid) temp.add(arr[l++]);
        while(r<=right) temp.add(arr[r++]);
        
        for(int i=left; i<=right; i++) arr[i]=temp.get(i-left); 
    }

    public int cntInv(int nums[], int left, int mid, int right){
        int cnt=0;
        int r=mid+1;
        for(int l=left; l<=mid; l++){
            while(r<=right && (long)nums[l]>2L*nums[r]){
                r++;
            }
            cnt+=r-(mid+1);
        }
        return cnt;
    }
    public int mergeSort(int nums[], int left, int right){
        if(left>=right) return 0;
        int mid=(left+right)/2;
        int cnt=0;
        cnt+=mergeSort(nums,left,mid);
        cnt+=mergeSort(nums,mid+1, right);
        cnt+=cntInv(nums,left,mid,right);
        merge(nums,left,mid,right);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}