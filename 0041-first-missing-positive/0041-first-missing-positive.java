class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int exp=1;
        for(int n: nums){
            if(n<exp) continue;
            if(n==exp) exp++;
            else break;
        }
        return exp;
    }
}