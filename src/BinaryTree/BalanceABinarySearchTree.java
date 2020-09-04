package BinaryTree;

import com.zzy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BalanceABinarySearchTree {
    /*
        Given a binary search tree, return a balanced binary search tree with the same node values.

        A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

        If there is more than one answer, return any of them.
    */

    // inorder traverse + construct bst using sorted array
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root);
        return constructBST(0, list.size() - 1);
    }

    private void inorderTraverse(TreeNode node) {
        if (node == null) return;
        inorderTraverse(node.left);
        list.add(node);
        inorderTraverse(node.right);
    }

    private TreeNode constructBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = list.get(mid);
        root.left = constructBST(start, mid - 1);
        root.right = constructBST(mid + 1, end);
        return root;
    }

    private void inorderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur);
            cur = cur.right;
        }
    }
}
