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
    public ListNode getK(ListNode head,int k){
        ListNode temp=head;
        for(int i=1; i<k; i++){
            if(temp.next==null) return null;
            temp=temp.next;
        }
        return temp;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;

        ListNode curr=head;
        ListNode prev=null;
        ListNode after;
        while(curr!=null){
            ListNode kth=getK(curr,k);
            if(kth!=null){
                after=kth.next;
                kth.next=null;
                ListNode newHead=reverseList(curr);
                if(curr==head){
                    head=newHead;
                    prev=curr;
                }
                else{
                    prev.next=newHead;
                    prev=curr;
                }
                curr.next=after;
                curr=curr.next;
            }
            else{
                break;
            }
        }
        return head;
    }
}