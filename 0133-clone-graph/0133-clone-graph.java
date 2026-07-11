/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> map= new HashMap<>();
        Queue<Node> queue= new LinkedList<>();
        map.put(node, new Node(node.val));
        queue.offer(node);
        while(!queue.isEmpty()){
            Node curr=queue.poll();
            for(Node a: curr.neighbors){
                if(!map.containsKey(a)){
                    queue.offer(a);
                    map.put(a, new Node(a.val));
                }
                map.get(curr).neighbors.add(map.get(a));
            }  
        }
        return map.get(node);
    }
}