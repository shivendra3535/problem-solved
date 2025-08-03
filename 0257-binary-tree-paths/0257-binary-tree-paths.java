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
    public void addPaths(TreeNode root, String ans, List<String> res){
        if(root.left==null && root.right==null){
            res.add(ans);
        }
        if(root.left!=null){
            addPaths(root.left,ans+"->"+ root.left.val, res);
        }
        if(root.right!=null){
            addPaths(root.right,ans+"->"+ root.right.val, res);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res= new ArrayList<>();
        if(root==null) return res;
        String ans=""+ root.val;
        addPaths(root,ans,res);
        return res;
    }
}