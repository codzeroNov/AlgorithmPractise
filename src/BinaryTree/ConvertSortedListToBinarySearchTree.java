package BinaryTree;

import com.zzy.ListNode;
import com.zzy.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    /*
        给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail)
            return null;

        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head, slow);
        node.right = helper(slow.next, tail);

        return node;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;//cut it into two parts
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST2(head);
        node.right = sortedListToBST2(slow.next);

        return node;
    }
}
