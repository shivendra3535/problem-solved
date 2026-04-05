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
        this.node=node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> queue= new LinkedList<>();
        queue.offer(new Pair(root,0));
        int max=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            int min=queue.peek().index;
            int first=0;
            int last=0;
            for(int i=0; i<size; i++){
                Pair p=queue.poll();
                if(i==0) first=p.index-min;
                if(i==size-1) last=p.index-min;
                if(p.node.left!=null) queue.offer(new Pair(p.node.left,2*p.index+1));
                if(p.node.right!=null) queue.offer(new Pair(p.node.right,2*p.index+2));
            }
            max=Math.max(max,last-first+1);
        }
        return max;
    }
}