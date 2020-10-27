package BinaryTree;

import com.zzy.TreeNode;

import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    /*
    把一棵搜索二叉树，转化成有序的双向链表。
     */
    public TreeNode BSTToDoubleLinkedList(TreeNode root){
        if (root == null) return null;

        TreeNode curr = root, head = null, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        boolean isFirst = true;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (isFirst) {
                head = curr;
                prev = curr;
                isFirst = false;
            } else {
                prev.right = curr;
                curr.left = prev;
                prev = curr;
            }
            curr = curr.right;
        }

        return head;
    }
}
