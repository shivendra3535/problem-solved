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
class Tupple{
    TreeNode node;
    int level;
    int vertices;
    Tupple(TreeNode node, int level, int vertices){
        this.node=node;
        this.level=level;
        this.vertices=vertices;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();   
        if(root==null) return res;
        Queue<Tupple> queue= new LinkedList<>();
        queue.offer(new Tupple(root,0,0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map= new TreeMap<>();
        while(!queue.isEmpty()){
            Tupple t=queue.poll();
            TreeNode node=t.node;
            int level=t.level;
            int vertices=t.vertices;
            if(!map.containsKey(vertices)){
                map.put(vertices, new TreeMap<>());
            }
            if(!map.get(vertices).containsKey(level)){
                map.get(vertices).put(level, new PriorityQueue<>());
            }
            map.get(vertices).get(level).add(node.val);
            if(node.left!=null) queue.offer(new Tupple(node.left,level+1,vertices-1));
            if(node.right!=null) queue.offer(new Tupple(node.right,level+1,vertices+1));
        } 
        for(TreeMap<Integer, PriorityQueue<Integer>> level: map.values()){
            List<Integer> ans= new ArrayList<>();
            for(PriorityQueue<Integer> pq: level.values()){
                while(!pq.isEmpty()){
                    ans.add(pq.poll());
                }
            }
            res.add(ans);
        }
        return res;
    }
}