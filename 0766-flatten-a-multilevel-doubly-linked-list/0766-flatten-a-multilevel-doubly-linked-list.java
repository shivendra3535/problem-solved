/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)
        {
            return null;
        }
        Node current=head;
        Node nextNode;
        while(current!=null){
            if(current.child!=null){
                nextNode=current.next;
                current.next=flatten(current.child);
                current.next.prev=current;
                current.child=null;

                while(current.next!=null)
                {
                    current=current.next;
                }
                if(nextNode!=null){
                current.next=nextNode;
                nextNode.prev=current;
                }
            }
                current=current.next;
        }
        return head;     
    }
}