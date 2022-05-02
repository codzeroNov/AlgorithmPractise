package LinkedList;

import com.zzy.ListNode;

import java.util.HashSet;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }

        return null;
    }

    /**
     * Let the distance from the first node to the node where cycle begins be A, and let say the slow pointer travels A+B.
     * The fast pointer must travel 2A+2B to catch up. The cycle size is N.
     * Full cycle is also how much more fast pointer has traveled than slow pointer at meeting point.
     *
     * A+B+N = 2A+2B
     * N=A+B
     */

    public ListNode detectCycle2(ListNode head) {
        if (head == null) return  null;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }

        return null;
    }

}
