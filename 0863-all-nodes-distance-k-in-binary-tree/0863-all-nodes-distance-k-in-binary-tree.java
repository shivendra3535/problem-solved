/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void mapParents(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                TreeNode node= queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    map.put(node.left,node);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    map.put(node.right,node);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map= new HashMap<>();
        mapParents(root,map);
        List<Integer> res= new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue= new LinkedList<>();
        HashSet<TreeNode> set= new HashSet<>();
        queue.offer(target);
        set.add(target);
        int distance=0;
        while(!queue.isEmpty()){
            int size= queue.size();
            if(distance==k) break;
            distance++;

            for(int i=0; i<size; i++){
                TreeNode node=queue.poll();
                if(node.left!=null && !set.contains(node.left)){
                   TreeNode left=node.left;
                   set.add(left);
                   queue.offer(left);
                }
                if(node.right!=null && !set.contains(node.right)){
                   TreeNode right=node.right;
                   set.add(right);
                   queue.offer(right);
                }
                if(map.containsKey(node) && !set.contains(map.get(node))){
                   TreeNode parent=map.get(node);
                   set.add(parent);
                   queue.offer(parent);
                }
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll().val);
        }
       return res;
    }
}