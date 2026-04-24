class Solution {
    public int majorityElement(int[] nums) {
        int ele=-1;
        int cnt=0;
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
        else return -1;
    }
}