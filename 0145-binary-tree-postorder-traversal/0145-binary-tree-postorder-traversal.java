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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        Stack<TreeNode> st= new Stack<>();
        if(root==null) return res;
        TreeNode curr=root;
        TreeNode temp;
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                temp=st.peek().right;
                if(temp==null){
                    temp=st.pop();
                    res.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        res.add(st.peek().val);
                        temp=st.pop();
                    }
                }
                else{
                    curr=temp;
                }
            }
        }
        return res;
    }
}