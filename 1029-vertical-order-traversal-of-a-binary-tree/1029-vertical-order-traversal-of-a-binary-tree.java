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
    int vertical;
    int level;
    Tupple(TreeNode node, int vertical, int level){
        this.node=node;
        this.vertical=vertical;
        this.level=level;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Tupple> q= new LinkedList<>();
        q.offer(new Tupple(root,0,0));
        while(!q.isEmpty()){
            Tupple tupple= q.poll();
            TreeNode node=tupple.node;
            int vertical= tupple.vertical;
            int level= tupple.level;

            if(!map.containsKey(vertical)){
                map.put(vertical,new TreeMap<>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level,new PriorityQueue<>());
            }
            map.get(vertical).get(level).offer(node.val);
            if(node.left != null){
                q.offer(new Tupple(node.left, vertical-1, level+1));
            }
            if(node.right != null){
                q.offer(new Tupple(node.right,vertical+1, level+1));
            }
        }
        List<List<Integer>> list= new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            list.add(new ArrayList<>());
                for(PriorityQueue<Integer> nodes: ys.values()){
                    while(!nodes.isEmpty()){
                        list.get(list.size()-1).add(nodes.poll());
                    }
                }
        }
      return list;
    }
}