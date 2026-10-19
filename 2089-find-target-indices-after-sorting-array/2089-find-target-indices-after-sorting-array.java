class Solution {

    public int lowerB(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int upperB(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        int lb = lowerB(nums, target);
        int ub = upperB(nums, target);

        List<Integer> ans = new ArrayList<>();
        for (int i = lb; i < ub; i++) {
            ans.add(i);
        }

        return ans;
    }
}