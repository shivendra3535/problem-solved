class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int Max_no = 0; // Start with 0 instead of Integer.MIN_VALUE

        for (int i : nums) {
            if (i == 1) {
                cnt++;  // Increase count if 1 is found
                Max_no = Math.max(Max_no, cnt); // Update max count
            } else {
                cnt = 0; // Reset count if 0 is found
            }
        }
        return Max_no;
    }
}
