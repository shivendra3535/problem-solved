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
        HashMap<Node, Node> map= new HashMap<>();
        Node newHead=copyNode;
        Node temp=head;
        while(temp!=null){
            copyNode.next=new Node(temp.val);
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
            temp=temp.next;
            temp2=temp2.next;
        }
        return newHead.next;
    }
}