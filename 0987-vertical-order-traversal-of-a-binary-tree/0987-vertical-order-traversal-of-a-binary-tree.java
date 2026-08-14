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
    class Tupple{
        TreeNode node;
        int vert;
        int lev;
        Tupple(TreeNode node, int vert, int lev){
            this.node= node;
            this.vert=vert;
            this.lev=lev;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null) return res;
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Tupple> queue= new LinkedList<>();
        queue.offer(new Tupple(root,0,0));
        while(!queue.isEmpty()){
            Tupple t= queue.poll();
            TreeNode curr=t.node;
            int vertices=t.vert;
            int level=t.lev;
            if(curr.left!=null) queue.offer(new Tupple(curr.left,vertices-1,level+1));
            if(curr.right!=null) queue.offer(new Tupple(curr.right,vertices+1,level+1));
            if(!map.containsKey(vertices)) map.put(vertices,new TreeMap<>());
            if(!map.get(vertices).containsKey(level)) map.get(vertices).put(level, new PriorityQueue<>());
            map.get(vertices).get(level).offer(curr.val);
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> levels: map.values()){
            List<Integer> ver= new ArrayList<>();
            for(PriorityQueue<Integer> pq: levels.values()){
                while(!pq.isEmpty()){
                    ver.add(pq.poll());
                }
            }
            res.add(ver);
        }
        return res;
    }
}