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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode after=temp.next;
            temp.next=prev;
            prev=temp;
            temp=after;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode s1=head;
        ListNode s2=reverseList(slow.next);
        slow.next = null;
        
        while(s1!=null && s2!=null){
            ListNode s1Next=s1.next;
            ListNode s2Next=s2.next;
            s2.next=s1Next;
            s1.next=s2;
            s2=s2Next;
            s1=s1Next;
        }
    }
}