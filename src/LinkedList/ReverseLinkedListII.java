package LinkedList;

import com.zzy.ListNode;

public class ReverseLinkedListII {
/*
    Reverse a linked list from position m to n. Do it in one-pass.
    Note: 1 ≤ m ≤ n ≤ length of list.

    Example:
    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL
*/

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start, prev, then;

        //node's index starts form 1
        prev = dummy;
        for (int i = 0; i < m - 1; i++)
            prev = prev.next;

        start = prev.next;
        while (n - m > 0) {
            then = start.next;
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;

            n--;
        }

        return dummy.next;
    }
}
