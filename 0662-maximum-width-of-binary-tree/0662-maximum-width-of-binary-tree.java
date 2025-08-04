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
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index){
        this.node= node;
        this.index= index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair> queue= new LinkedList<>();
        int ans=0;
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            int min= queue.peek().index;
            int first=0;
            int last=0;
            for(int i=0; i<levelSize; i++){
                Pair p= queue.poll();
                int cur_id= p.index-min;
                if(i == 0) first=cur_id;
                if(i == levelSize-1) last= cur_id;
                if(p.node.left != null) queue.offer(new Pair(p.node.left, 2*cur_id + 1));
                if(p.node.right != null) queue.offer(new Pair(p.node.right, 2*cur_id +2));
            }
            ans= Math.max(ans, last-first+1);

        }
        return ans;

    }
}