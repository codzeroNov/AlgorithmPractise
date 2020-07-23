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

}
