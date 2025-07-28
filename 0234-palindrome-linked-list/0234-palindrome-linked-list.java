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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> stacks= new ArrayList<Integer>();
        int top=-1;
        ListNode temp=head;
        while(temp!=null)
        {
            
            stacks.add(temp.val);
            top++;
            temp=temp.next;
        }  
        temp=head;
        while(temp!=null)
        {
            if(temp.val!=stacks.get(top))
            {
                return false;
            }
            top--;
            temp=temp.next;
        }
        return true;              
        }

}