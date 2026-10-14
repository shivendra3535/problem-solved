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
    public TreeNode bfs(TreeNode root, HashMap<TreeNode, TreeNode> map, int key){
        Queue<TreeNode> queue= new LinkedList<>();
        TreeNode start=null;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                TreeNode node=queue.poll();
                if(node.val==key) start=node;
                if(node.left!=null){
                    map.put(node.left,node);
                    queue.offer(node.left);
                }

                if(node.right!=null){
                    map.put(node.right,node);
                    queue.offer(node.right);
                }
            }
        }
        return start;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> map= new HashMap<>();
        TreeNode str=bfs(root,map,start);
        
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(str);
        HashSet<TreeNode> set= new HashSet<>();
        int cnt=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            cnt++;
            for(int i=0; i<size; i++){

                TreeNode node=queue.poll();
                set.add(node);

                if(map.containsKey(node) && !set.contains(map.get(node))){
                    queue.offer(map.get(node));
                }

                if(node.left!=null && !set.contains(node.left)){
                    queue.offer(node.left);
                }

                if(node.right!=null && !set.contains(node.right)){
                    queue.offer(node.right);
                }
            }
        }
        return cnt;
    }
}