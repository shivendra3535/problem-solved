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
    public TreeNode bst(int preorder[], int i[], int min, int max){
        if(i[0]==preorder.length || preorder[i[0]]<min || preorder[i[0]]>max) return null;

        TreeNode root= new TreeNode(preorder[i[0]++]);
        root.left=bst(preorder,i,min,root.val);
        root.right=bst(preorder,i,root.val,max);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return null;
        return bst(preorder,new int[]{0},Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}