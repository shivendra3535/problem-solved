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
        List<Integer> inorder= new ArrayList<>();
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
                inorder.add(cur.val);
                cur=cur.right;
            }
        }
        int left=0;
        int right=inorder.size()-1;
        while(left<right){
            if(inorder.get(left)+inorder.get(right) == k) return true;
            else if(inorder.get(left)+inorder.get(right) < k) left++;
            else{
                right--;
            }
        }
        return false;
    }
}