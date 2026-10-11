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
    public TreeNode lastRight(TreeNode root){
        if(root.right==null) return root;
        return lastRight(root.right);
    }
    public TreeNode helper(TreeNode root){
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        TreeNode lastR=lastRight(root.left);
        TreeNode rightC=root.right;
        lastR.right=rightC;
        return root.left;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val==key){
            return helper(root);
        }
        TreeNode curr=root;
        while(curr!=null){
            if(curr.val>key){
                if(curr.left!=null && curr.left.val==key){
                    curr.left=helper(curr.left);
                    break;
                }
                curr=curr.left;
            }
            else {
                if(curr.right!=null && curr.right.val==key){
                    curr.right=helper(curr.right);
                    break;
                }
                curr=curr.right;
            }
        }
        return root;
    }
}