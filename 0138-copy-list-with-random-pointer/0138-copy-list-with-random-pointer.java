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
    public void getMap(Node head,HashMap<Node,Node> map){
        Node temp=head;
        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node,Node> map= new HashMap<>();
        getMap(head,map);
        Node temp=head;
        Node head2=map.get(head);
        while(temp!=null){
            Node temp2=map.get(temp);
            temp2.next=map.get(temp.next);
            temp2.random=map.get(temp.random);
            temp=temp.next;
        }
        return head2;
    }
}