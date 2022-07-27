package Heap;

import com.zzy.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     * **/

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode node : lists)
            if (node != null)
                pq.offer(node);

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null) {
                pq.offer(tail.next);
            }
        }

        return dummy.next;
    }
}
