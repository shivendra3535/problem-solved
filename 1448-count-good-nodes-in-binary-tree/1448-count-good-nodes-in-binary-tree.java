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
    public int dfs(TreeNode root, int parent){
        if(root==null) return 0;
        
        int par=root.val>=parent?root.val:parent;
        int left=dfs(root.left,par);
        int right=dfs(root.right,par);
        return root.val>=parent?(1+left+right):(left+right);
    }
    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }
}