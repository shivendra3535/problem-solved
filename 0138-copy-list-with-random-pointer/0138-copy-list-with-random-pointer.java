/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node copyRandomList(Node head) {
         Node copyNode= new Node(-1);
         Node newHead=copyNode;
         Node temp=head;
         HashMap<Node, Node> map= new HashMap<>();
         while(temp!=null){
            Node newNode= new Node(temp.val);
            copyNode.next=newNode;
            copyNode=copyNode.next;
            map.put(temp,copyNode);
            temp=temp.next;
         }
         temp=head;
         Node temp2=newHead.next;
         while(temp!=null){
            if(temp.random==null){
                temp2.random=null;
            }
            else{
                temp2.random=map.get(temp.random);
            }
            temp2=temp2.next;
            temp=temp.next;
         }
        return newHead.next;
    }
}