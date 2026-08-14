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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st= new Stack<>();
        List<Integer> res= new ArrayList<>();
        if(root==null) return res;
        TreeNode curr=root;
        while(true){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                if(st.isEmpty()) break;
                TreeNode temp=st.pop();
                res.add(temp.val);
                curr=temp.right;
            }
        }
        return res;
    }
}