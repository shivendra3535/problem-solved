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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head;
        ListNode fast=head;
        for(int i=1; i<=n; i++){
            fast=fast.next;
            if(fast==null){
                return head.next;
            }
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode temp=head;
        while(temp.next!=slow){
            temp=temp.next;
        }
        temp.next=slow.next;
        slow.next=null;
        return head;
    }
}