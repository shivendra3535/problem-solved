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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<TreeNode> res= new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node=queue.poll();
                res.add(node);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            if(level%2==1){
                int left=0;
                int right=res.size()-1;
                while(left<right){
                    int temp=res.get(left).val;
                    res.get(left).val=res.get(right).val;
                    res.get(right).val=temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}