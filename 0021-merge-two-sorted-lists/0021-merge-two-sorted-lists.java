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
    public ListNode merge(ListNode list1, ListNode list2)
    { 
        if (list1 == null) return list2;
        if (list2 == null) return list1;


        ListNode newHead;
        ListNode left=list1;
        ListNode right=list2;
        ListNode newNode;
        
        if(left.val<=right.val){
           newNode=left;
           newHead=newNode;
           left=left.next;
        }
        else
        {
            newNode=right;
            newHead=newNode;
            right=right.next;
        }
        while(left!=null&&right!=null)
        {
            if(left.val<=right.val)
            {
                newNode.next=left;
                newNode=newNode.next;
                left=left.next;
            }
            else
            {
                newNode.next=right;
                newNode=newNode.next;
                right=right.next;
            }
        }
        while(left!=null)
        {
            newNode.next=left;
            newNode=newNode.next;
            left=left.next;
        }
        while(right!=null)
        {
            newNode.next=right;
            newNode=newNode.next;
            right=right.next;
        }
        return newHead;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return (merge(list1,list2));
    }
}