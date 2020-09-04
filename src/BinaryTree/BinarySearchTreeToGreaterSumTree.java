package BinaryTree;

import com.zzy.TreeNode;

import java.util.Stack;

public class BinarySearchTreeToGreaterSumTree {
    /*
        Given the root of a binary search tree with distinct values,
        modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.
    */
    // post-order travel
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        root.val += pre;
        pre = root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }

    // iterative way
    public TreeNode bstToGst2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int pre = 0;

        while (!stack.isEmpty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            cur.val += pre;
            pre = cur.val;
            cur = cur.left;
        }

        return root;
    }

}
