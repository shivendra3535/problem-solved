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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        List<Integer> res= new ArrayList<>();
        while(!queue.isEmpty()){
            int levelNum= queue.size();
            for(int i=0; i<=levelNum-1; i++){
                TreeNode node=queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(i==levelNum-1) res.add(node.val);
            }
        }
        return res;
    }
}