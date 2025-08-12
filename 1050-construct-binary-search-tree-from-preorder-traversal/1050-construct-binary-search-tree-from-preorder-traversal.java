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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return null;
        if(preorder.length==1) return new TreeNode(preorder[0]);
        TreeNode root= constructBST(preorder,0,preorder.length-1);
        return root;
    }
    public TreeNode constructBST(int[]preorder, int preStart, int preEnd){
        if(preStart>preEnd) return null;
        TreeNode root= new TreeNode(preorder[preStart]);
        int i=preStart+1;
        while(i<=preEnd){
            if(preorder[i]>root.val){
                break;
            }
            i++;
        }
        root.left=  constructBST(preorder,preStart+1, i-1);
        root.right= constructBST(preorder,i,preEnd);
        return root;
    }
}