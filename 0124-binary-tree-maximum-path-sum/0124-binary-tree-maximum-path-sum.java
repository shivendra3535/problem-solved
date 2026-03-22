/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
     public int maxDepth(TreeNode root,int diameter[]) {
        if(root==null) return 0;
        int left=Math.max(0,maxDepth(root.left,diameter));
        int right=Math.max(0,maxDepth(root.right,diameter));
        diameter[0]=Math.max(diameter[0],root.val+left+right);
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        int diameter[]= new int[1];
        diameter[0]=Integer.MIN_VALUE;
        int sum= maxDepth(root,diameter);
        return diameter[0];
    }
}
