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
    public boolean isValid(TreeNode root, long max, long min){
        if(root==null) return true;
        if(min>=root.val || root.val>=max) return false;
        boolean left=isValid(root.left,root.val,min);
        boolean right=isValid(root.right,max,root.val);
        return left&&right;
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MAX_VALUE, Long.MIN_VALUE);
    }
}