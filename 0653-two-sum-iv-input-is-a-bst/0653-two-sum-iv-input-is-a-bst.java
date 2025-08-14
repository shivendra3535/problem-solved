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
        Set<Integer> mapSet= new HashSet<>();
        Stack<TreeNode> stack= new Stack<>();
        TreeNode cur=root;
        while(true){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else{
                if(stack.isEmpty())break;
                cur=stack.pop();
                int compliment=k-cur.val;
                if(mapSet.contains(compliment)) return true;
                mapSet.add(cur.val);
                cur=cur.right;
            }
        }
        return false;
    }
}