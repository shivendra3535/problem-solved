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
        int flag=0;
        while(!queue.isEmpty()){
            int levelNum= queue.size();
            List<Integer> levelNodes= new ArrayList<>();
            for(int i=0; i<levelNum; i++){
                TreeNode node= queue.poll();
                if(node.left!=null)
                {
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                levelNodes.add(node.val);
            }
            if(flag==1){
                Collections.reverse(levelNodes);
                result.add(levelNodes);
                flag=0;
            }
            else{
                result.add(levelNodes);
                flag=1;
            }
        }
        return result;
    }
}