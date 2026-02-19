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
    public ListNode reverse(ListNode head){
        ListNode before=null;
        ListNode curr=head;
        ListNode after;
        while(curr!=null){
            after=curr.next;
            curr.next=before;
            before=curr;
            curr=after;
        }
        return before;
    }
    public ListNode getKthNode(ListNode head, int k){
        ListNode temp=head;
        for(int i=1; i<k; i++){
            if(temp.next==null){
                return null;
            }
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        ListNode prevLast=null;
        while(temp!=null){
            ListNode kthNode= getKthNode(temp,k);
            if(kthNode==null){
                if(prevLast!=null){
                    prevLast.next=temp;
                }
                break;
            }
 
            ListNode nextNode= kthNode.next;
            kthNode.next=null;
            ListNode newHead=reverse(temp);
            if(temp==head){
                head=newHead;
            }
            else{
                prevLast.next=newHead;
            }
            prevLast=temp;
            temp=nextNode;
        }
        return head;
    }
}