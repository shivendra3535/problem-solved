class Solution {
    public int firstMissingPositive(int[] nums) {
        int arr[]= new int[nums.length];
        for(int n: nums){
            if(n>0 && n<=nums.length){
                arr[n-1]=n;
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0) return i+1;
        }
        return arr.length+1;
    }
}