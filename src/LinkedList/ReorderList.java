package LinkedList;

import com.zzy.ListNode;

public class ReorderList {
/*
    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
    将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    示例 1:

    给定链表 1->2->3->4, 重新排列为 1->4->2->3.
    示例 2:

    给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
*/

    public void reorderList(ListNode head) {
        if (head == null) return;
        //1.找到链表中间点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.将链表后半部分反转
        ListNode pre = null, cur = slow.next;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }
        slow.next = null;
        //3.将后半部分依次插入前半部分合并
        ListNode head1 = head, head2 = pre;
        while (head1 != null && head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head2.next = next1;

            head1 = next1;
            head2 = next2;
        }
    }

}
