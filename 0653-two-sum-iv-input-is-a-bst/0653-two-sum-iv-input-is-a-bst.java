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
class BSTIterator {
    Stack<TreeNode> st;
    boolean asc;
    public void pushAll(TreeNode root){
        TreeNode curr=root;
        while(curr!=null){
            st.push(curr);
            if(asc==true){
              curr=curr.left;
            }
            else curr=curr.right;
        }
    }

    public BSTIterator(TreeNode root, boolean asc) {
        st=new Stack<>();
        this.asc=asc;
        pushAll(root);
    }
    
    public int next() {
        TreeNode nextS=st.pop();
        if(asc==true) pushAll(nextS.right);
        else pushAll(nextS.left);

        return nextS.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
class Solution {

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left= new BSTIterator(root,true);
        BSTIterator right=new BSTIterator(root,false);
        int i=left.next();
        int j=right.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=left.next();
            else j=right.next();
        }
        return false;
    }
}