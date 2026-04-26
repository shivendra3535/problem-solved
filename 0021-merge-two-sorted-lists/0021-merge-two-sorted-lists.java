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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy= new ListNode(-1);
        ListNode temp=dummy;
        ListNode l1=list1;
        ListNode l2=list2;
        if(list1.val<list2.val){
            temp.next=new ListNode(list1.val);
            temp=temp.next;
            l1=l1.next;
        }
        else{
            temp.next=new ListNode(list2.val);
            temp=temp.next;
            l2=l2.next;
        }
       
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
               temp.next=new ListNode(l1.val);
               temp=temp.next;
               l1=l1.next;
            }
           else{
               temp.next=new ListNode(l2.val);
               temp=temp.next;
               l2=l2.next;
            }
        }
        while(l1!=null){
            temp.next= new ListNode(l1.val);
            temp=temp.next;
            l1=l1.next;
        }
        while(l2!=null){
            temp.next=new ListNode(l2.val);
            temp=temp.next;
            l2=l2.next;
        }
        return dummy.next;
    }
}