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
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode mid= middleNode(head);
        ListNode prev=head;
        while(prev.next!=mid){
            prev=prev.next;
        }
        prev.next=null;
        ListNode temp=head;
        mid=reverseList(mid);
        while(temp!=null && mid!=null){
            if(temp.val!=mid.val) return false;
            temp=temp.next;
            mid=mid.next;
        }
        return true;
    }
}