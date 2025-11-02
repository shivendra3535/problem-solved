class Solution {
    public int singleNumber(int[] nums) {
        int XOR=0;
        for(int i: nums){
            XOR^=i;
        }
        return XOR;
    }
}