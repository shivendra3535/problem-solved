
class Solution {
    public boolean isLeaf(TreeNode root) {
        return root != null &&
               root.left == null &&
               root.right == null;
    }

    public List<Integer> leaf(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = st.pop();

                if (isLeaf(node)) {
                    res.add(node.val);
                }

                curr = node.right;
            }
        }

        return res;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = leaf(root1);
        List<Integer> res2 = leaf(root2);

        return res1.equals(res2);
    }
}
