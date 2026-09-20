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
    ListNode sortedMerge(ListNode head1, ListNode head2) {

        if(head1==null && head2!=null) return head2;
        else if(head1!=null && head2==null) return head1;
        if(head1==null || head2==null) return null;
        
        ListNode dummy= new ListNode(-1);
        ListNode temp=dummy;
        
        ListNode i=head1;
        ListNode j=head2;
        
        if(i.val<=j.val){
            temp.next=i;
            temp=temp.next;
            i=i.next;
        }
        else{
            temp.next=j;
            temp=temp.next;
            j=j.next;
        }
        
        while(i!=null && j!=null){
            if(i.val<=j.val){
               temp.next=i;
               temp=temp.next;
               i=i.next;
            }
            else{
                temp.next=j;
                temp=temp.next;
                j=j.next;
            }
        }
        
        while(i!=null){
            temp.next=i;
            i=i.next;
            temp=temp.next;
        }
        
        while(j!=null){
            temp.next=j;
            j=j.next;
            temp=temp.next;
        }
        
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode ls=lists[0];
        for(int i=1; i<lists.length; i++){
            ls=sortedMerge(ls,lists[i]);
        }
        return ls;
    }
}