class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int ele=-1;
        for(int n: nums){
            if(cnt==0){
                cnt=1;
                ele=n;
            }
            else if(ele==n) cnt++;
            else cnt--;
        }
        cnt=0;
        for(int n: nums){
            if(n==ele) cnt++;
        }
        if(cnt>=nums.length/2) return ele;
        return -1;
    }
}