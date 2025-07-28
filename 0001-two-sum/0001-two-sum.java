class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement exists in the hashmap
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            // Store the current number and its index
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // Return if no pair is found
    }
}

