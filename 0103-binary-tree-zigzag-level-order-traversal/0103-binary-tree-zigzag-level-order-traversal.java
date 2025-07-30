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
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        List<List<Integer>> result= new ArrayList<>();
        queue.offer(root);
        if(root==null)return result;
        boolean flag=true;
        while(!queue.isEmpty()){
            int levelNum= queue.size();
            Deque<Integer> levelNodes = new LinkedList<>();
            for(int i=0; i<levelNum; i++){
                TreeNode node= queue.poll();
                int index= flag?i:levelNum-1-i;
                if(node.left!=null)
                {
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(flag){
                    levelNodes.addLast(node.val);
                } else {
                    levelNodes.addFirst(node.val);
                }
            }
            flag=!flag;
            result.add(new ArrayList<>(levelNodes));
        }
        return result;
    }
}