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
    TreeNode prev=null;
    public void flatten1(TreeNode root){
        if(root==null) return;
        flatten1(root.right);
        flatten1(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
    public void flatten(TreeNode root) {
        flatten1(root);
    }
}