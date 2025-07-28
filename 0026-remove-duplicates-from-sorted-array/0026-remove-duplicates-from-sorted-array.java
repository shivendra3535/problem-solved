class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        HashSet<Integer> set = new HashSet<>();

        
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                nums[index++] = num; 
            }
        }

        return index;
    }
}