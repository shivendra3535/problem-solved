class Solution {
    class Info {
        int max, min, sum, maxi;
        boolean isBst;
        Info(int max, int min, int sum, boolean isBst, int maxi) {
            this.max = max; this.min = min; this.sum = sum;
            this.isBst = isBst; this.maxi = maxi;
        }
    }

    private Info maxSum(TreeNode root) {
        if (root == null) return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true, 0);

        Info left = maxSum(root.left);
        Info right = maxSum(root.right);
        int best = Math.max(left.maxi, right.maxi);

        if (left.isBst && right.isBst && root.val > left.max && root.val < right.min) {
            int sum = root.val + left.sum + right.sum;
            return new Info(
                Math.max(root.val, right.max),
                Math.min(root.val, left.min),
                sum,
                true,
                Math.max(sum, best)
            );
        }
        return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, false, best);
    }

    public int maxSumBST(TreeNode root) {
        return maxSum(root).maxi;
    }
}