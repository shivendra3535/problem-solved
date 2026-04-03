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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        if(root==null) return res;
        queue.offer(root);
        boolean flag=true;
        while(!queue.isEmpty()){
            int levelNum=queue.size();
            Deque<Integer> level= new LinkedList<>();
            for(int i=0; i<levelNum; i++){
                TreeNode node=queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                if(flag){
                    level.addLast(node.val);
                }
                else{
                    level.addFirst(node.val);
                }
            }
            res.add(new ArrayList<>(level));
            flag=!flag;
        }
        return res;
    }
}