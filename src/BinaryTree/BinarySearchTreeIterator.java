package BinaryTree;

import com.zzy.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {
/*
    Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
    Calling next() will return the next smallest number in the BST.
*/

    class BSTIterator {
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushAll(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            pushAll(node.right);
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

}
