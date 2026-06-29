class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0;
        int maxCnt=0;
        for(int n: nums){
            if(n==1){
                cnt++;
            }
            else{
                maxCnt=Math.max(cnt,maxCnt);
                cnt=0;
            }
        }
        maxCnt=Math.max(maxCnt, cnt);
        return maxCnt;
    }
}