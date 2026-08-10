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
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummy= new ListNode();
        ListNode temp=dummy;
        ListNode left=list1;
        ListNode right=list2;
        if(left.val<=right.val){
            temp.next=new ListNode(left.val);
            left=left.next;
            temp=temp.next;
        }
        else{
            temp.next=new ListNode(right.val);
            right=right.next;
            temp=temp.next;
        }
        while(left!=null && right!=null){
            if(left.val<=right.val){
               temp.next=new ListNode(left.val);
               left=left.next;
            }
            else{
               temp.next=new ListNode(right.val);
               right=right.next;
            }
            temp=temp.next;
        }
        if(left!=null) temp.next=left;
        if(right!=null) temp.next=right;
        return dummy.next;
    }
}