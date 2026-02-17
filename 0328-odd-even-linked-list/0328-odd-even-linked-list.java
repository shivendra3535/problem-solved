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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ArrayList<Integer> ds= new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            ds.add(temp.val);
            if(temp.next==null) break;
            temp=temp.next.next;
        }

        temp=head.next;
        while(temp!=null){
            ds.add(temp.val);
            if(temp.next==null) break;
            temp=temp.next.next;
        }
        temp=head;
        int i=0;
        while(temp!=null){
            temp.val=ds.get(i++);
            temp=temp.next;
        }
        return head;
    }
}