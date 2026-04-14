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
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> st= new Stack<>();
        HashSet<Integer> set= new HashSet<>();
        TreeNode curr=root;
        while(true){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                if(st.isEmpty()) break;
                curr=st.pop();
                int compliment=k-curr.val;
                if(set.contains(compliment)) return true;
                set.add(curr.val);
                curr=curr.right;
            }
        }
        return false;
    }
}