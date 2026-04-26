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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
    return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp2=slow;
        ListNode prev=null;
        ListNode after;
        while(temp2!=null){
            after=temp2.next;
            temp2.next=prev;
            prev=temp2;
            temp2=after;
        }
        while(prev!=null && head!=null){
            if(prev.val!=head.val) return false;
            prev=prev.next;
            head=head.next;
        }
        return true;
    }
}