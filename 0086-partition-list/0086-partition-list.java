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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1= new ListNode(-1);
        ListNode dummy2=new ListNode(-1);
        ListNode temp=head;
        ListNode temp2=dummy1;
        ListNode temp3=dummy2;
        while(temp!=null){
            if(temp.val>=x){
                temp2.next=new ListNode(temp.val);
                temp2=temp2.next;
            }
            else{
                temp3.next=new ListNode(temp.val);
                temp3=temp3.next;
            }
            temp=temp.next;
        }
        temp3.next=dummy1.next;
        return dummy2.next;
    }
}