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
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=slow;
        ListNode before=null;
        ListNode after;
        while(curr!=null){
            after=curr.next;
            curr.next=before;
            before=curr;
            curr=after;
        }
        ListNode temp=head;
        while(before!=null){
            if(before.val!=temp.val){
                return false;
            }
            before=before.next;
            temp=temp.next;
        }
        return true;
    }
}