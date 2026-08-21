class Solution {
    public int houseRobber(int nums[]){
        int next2=0;
        int next1=0;
        for(int i=nums.length-1; i>=0; i--){
            int take=nums[i]+next2;
            int notTake=next1;
            int current=Math.max(take, notTake);
            next2=next1;
            next1=current;
        }
        return next1;
    }
    public int deleteAndEarn(int[] nums) {
        int maxEle=Integer.MIN_VALUE;
        for(int n: nums){
            maxEle=Math.max(maxEle,n);
        }
        int points[]= new int[maxEle+1];
        for(int n: nums){
            points[n]+=n;
        }
        return houseRobber(points);
    }
}