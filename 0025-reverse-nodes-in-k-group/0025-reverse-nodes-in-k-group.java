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
     public static void reverse(ListNode head)
     {
        ListNode before=null;
        ListNode after;
        ListNode temp=head;
        while(temp!=null)
        {
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
        head=temp;
     }
     public ListNode getKthNode(ListNode head,int k)
     {
        ListNode temp=head;
        for(int i=1;i<k; i++)
        {
            if(temp.next==null)
            {
                return null;
            }
           temp=temp.next;
        }
        return temp;
     }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp;
        temp=head;
        ListNode prevLast=null;
        while(temp!=null)
        {
            ListNode kthelement= getKthNode(temp,k);
            if(kthelement==null)
            {
                if(prevLast!=null)
                {
                    prevLast.next=temp;
                }
                break;
            }
            
            ListNode nextNode=kthelement.next;
            kthelement.next=null;
            reverse(temp);
            if(temp==head)
            {
                head=kthelement;
            }
            else
            {
                prevLast.next=kthelement;
            }
            prevLast=temp;
            temp=nextNode;
        }
        return head;
    }

}