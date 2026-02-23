class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode prev = null;
        ListNode leftNode = head;
        ListNode rightNode = head;

        // Move leftNode to left position
        for (int i = 1; i < left; i++) {
            prev = leftNode;
            leftNode = leftNode.next;
        }

        // Move rightNode to right position
        for (int i = 1; i < right; i++) {
            rightNode = rightNode.next;
        }

        ListNode nextNode = rightNode.next;

        // Cut only right side
        rightNode.next = null;

        // Reverse isolated sublist
        ListNode reversedHead = reverseList(leftNode);

        // Connect left part
        if (prev != null) {
            prev.next = reversedHead;
        } else {
            head = reversedHead;   // left == 1 case
        }

        // Connect right part
        leftNode.next = nextNode;

        return head;
    }
}