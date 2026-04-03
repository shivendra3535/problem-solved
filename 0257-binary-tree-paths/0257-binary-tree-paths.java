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
    public void path(TreeNode root, String ans, List<String> res){
        if(root.left==null && root.right==null){
            res.add(ans);
            return;
        }
        if(root.left!=null) path(root.left,ans+"->"+root.left.val, res);
        if(root.right!=null) path(root.right,ans+"->"+root.right.val, res);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<String> res= new ArrayList<>();
        path(root,""+root.val,res);
        return res;
    }
}