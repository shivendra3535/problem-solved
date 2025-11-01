class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum= (n*(n+1))/2;
        int s=0;
        for(int a: nums){
            s+=a;
        }
        return sum-s;

    }
}