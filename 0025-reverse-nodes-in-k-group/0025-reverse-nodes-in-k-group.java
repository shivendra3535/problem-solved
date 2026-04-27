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
    public ListNode kThNode(ListNode head, int k){
        ListNode temp=head;
        for(int i=1; i<k; i++){
            if(temp==null) return null;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        ListNode after;
        while(temp!=null){
            after=temp.next;
            temp.next=prev;
            prev=temp;
            temp=after;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode kth=kThNode(curr,k);
            if(kth==null){
                if(prev!=null){
                    prev.next=curr;
                }
                break;
            }
            ListNode nextNode=kth.next;
            kth.next=null;
            ListNode newHead=reverse(curr);
            if(curr==head){
                head=newHead;
            }
            else{
                prev.next=newHead;
            }
            prev=curr;
            curr=nextNode;
        }
        return head;
    }
}