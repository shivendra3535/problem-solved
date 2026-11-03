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
    class Pair{
        int val;
        ListNode node;
        Pair(int val, ListNode node){
            this.val=val;
            this.node=node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1) return lists[0];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode node: lists){
            if(node!=null){
                pq.offer(new Pair(node.val,node));
            }
        }
        ListNode dummy= new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            temp.next=p.node;
            temp=temp.next;
            if(p.node.next!=null) pq.offer(new Pair(p.node.next.val,p.node.next));
        }
        return dummy.next;
    }
}