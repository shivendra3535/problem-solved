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
    public boolean checkBST(TreeNode root, long max, long min){
        if(root==null) return true;
        if( min >= root.val ||  root.val >= max){
            return false;
        }
        return checkBST(root.left, root.val, min) && checkBST(root.right,max,root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return checkBST(root,Long.MAX_VALUE, Long.MIN_VALUE);
}
}
