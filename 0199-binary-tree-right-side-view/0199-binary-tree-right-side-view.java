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
        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        if(root==null)return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum= queue.size();
            for(int i=0; i<levelNum; i++){
                TreeNode node= queue.poll();
                if(i==levelNum-1){
                    result.add(node.val);
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return result;
        
    }
}