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
class Info{
    int min;
    int max;
    int sum;
    boolean isBST;
    Info(int min, int max, int sum, boolean isBST){
        this.min=min;
        this.max=max;
        this.sum=sum;
        this.isBST=isBST;
    }
}
class Solution {
    int MaxSum=0;
    public Info largest(TreeNode root){
        if(root==null) return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE,0,true);
        Info left=largest(root.left);
        Info right=largest(root.right);
        if(left.isBST && right.isBST && root.val>left.max && root.val<right.min){
            MaxSum=Math.max(MaxSum,root.val+right.sum+left.sum);
            return new Info(
                Math.min(root.val,left.min),
                Math.max(root.val,right.max),
                root.val+left.sum+right.sum,
                true
                );
        }
        else{
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE,0,false);
        }
    }
    public int maxSumBST(TreeNode root) {
        Info in=largest(root);
        return MaxSum;
    }
}