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
    class Tup{
        int ver;
        int lev;
        TreeNode node;
        Tup(int ver, int lev, TreeNode node){
            this.ver=ver;
            this.lev=lev;
            this.node=node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null) return res;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tup> queue= new LinkedList<>();
        queue.offer(new Tup(0,0,root));
        while(!queue.isEmpty()){
            Tup t= queue.poll();
            int v=t.ver;
            int l=t.lev;
            TreeNode node=t.node;
            if(!map.containsKey(v)){
                map.put(v,new TreeMap<>());
            }
            if(!map.get(v).containsKey(l)){
                map.get(v).put(l,new PriorityQueue<>());
            }
            map.get(v).get(l).add(node.val);
            if(node.left!=null) queue.offer(new Tup(v-1,l+1,node.left));
            if(node.right!=null) queue.offer(new Tup(v+1,l+1,node.right));
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
    List<Integer> column = new ArrayList<>();

    for (PriorityQueue<Integer> pq : levels.values()) {
        while (!pq.isEmpty()) {
            column.add(pq.poll());
        }
    }

    res.add(column);
}
        return res;
    }
}