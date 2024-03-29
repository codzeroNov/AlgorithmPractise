package LinkedList;

import com.zzy.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
/*
    You are given two non-empty linked lists representing two non-negative integers.
    The most significant digit comes first and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Follow up:
    What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

    Example:
    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 8 -> 0 -> 7
*/


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode pre = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = pre;
            pre = newNode;
        }

        return pre;
    }

    // reverse two linked list
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode newL1Head = ReverseLinkedList(l1);
        ListNode newL2Head = ReverseLinkedList(l2);

        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (newL1Head != null || newL2Head != null || sum != 0) {
            if (newL1Head != null) {
                sum += newL1Head.val;
                newL1Head = newL1Head.next;
            }
            if (newL2Head != null) {
                sum += newL2Head.val;
                newL2Head = newL2Head.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            sum = sum / 10;
            prev.next = newNode;
            prev = newNode;
        }

        return ReverseLinkedList(dummy.next);
    }

    private ListNode ReverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

}
