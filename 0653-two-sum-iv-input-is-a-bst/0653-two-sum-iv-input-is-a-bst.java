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
class BSTIterator{
    Stack<TreeNode> st= new Stack<>();
    boolean forward;
    BSTIterator(TreeNode root,boolean forward){
        this.forward=forward;
        pushAll(root);
    }
    public void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            if(forward) root=root.left;
            else root=root.right;
        }
    }
    public int next(){
        TreeNode node=st.pop();
        if(forward) pushAll(node.right);
        else pushAll(node.left);
        return node.val;
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l = new BSTIterator(root,true);
        BSTIterator r = new BSTIterator(root,false);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;
    }
}