public class Solution {
    static void merge(int arr[],int low,int mid, int high){
        int left=low;
        int right=mid+1;
        ArrayList<Integer> temp= new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            arr[i]=temp.get(i-low);
        }
    }
    static int countReverse(int nums[], int low, int high, int mid){
        int right=mid+1;
        int cnt=0;
        for(int left=low; left<=mid; left++){
            while(right<=high && (long)nums[left]>2L*nums[right]){
                right++;
            }
            cnt+=right-(mid+1);
        }
        return cnt;
    }
    static int mergeSort(int arr[], int low, int high){
    if(low >= high){
        return 0;
    }
    int mid = (low + high) / 2;
    int cnt = 0;

    cnt += mergeSort(arr, low, mid);
    cnt += mergeSort(arr, mid+1, high);

    // ✅ FIXED ORDER HERE
    cnt += countReverse(arr, low, high, mid);

    merge(arr, low, mid, high);
    return cnt;
}

    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}