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
        ListNode tail = head;
        if (head == null) {
           return null; 
        }
        
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        ListNode temp = head;
        ListNode before = null;
        ListNode after;
        
        for (int i = 1; i <=length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
        head=before;
        return head; 
    }
}