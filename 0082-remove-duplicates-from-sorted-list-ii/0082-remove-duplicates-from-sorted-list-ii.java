/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if((head==null) || (head.next==null)) return head;
        ListNode dummyNode= new ListNode(-1);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        ListNode curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.val != curr.next.val){
                prev=prev.next;  
            }
            else{
                while(curr.next!=null && curr.next.val==curr.val){
                    curr=curr.next;
                }
                prev.next=curr.next;
            }
            curr=curr.next;
        }
        return dummyNode.next;
    }
}