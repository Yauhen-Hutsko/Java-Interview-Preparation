/**
 * LeetCode 92. Reverse Linked List II (Medium) — https://leetcode.com/problems/reverse-linked-list-ii/
 * Status: resolved — reverse LinkedList (partially).
 */
class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;

        for (int i = 0; i < left; i++) {
            previous = previous.next;   // previous saves pointer to start-1 positon.
        }

        ListNode pointerToNext = null;
        ListNode start = previous.next; // 2
        ListNode current = start;       // 2

        for (int i = left; i <= right; i++) {
            ListNode next = current.next; // save ref to the next element(3)
            current.next = pointerToNext;   // reassign pointer from the next(3) to previous(null) element. It means the end of subsequence.
            pointerToNext = current;        // move pointer 'previous' to the next element (one step to the right)
            current = next;               // move main pointer to the next element
            // thus both pointers gradually move to right side.
            // now current = 3, node(2) pointes from 3 to 1.
            //
        }
        previous.next = pointerToNext;
        start.next = current;

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
