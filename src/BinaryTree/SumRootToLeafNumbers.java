package BinaryTree;

import com.zzy.TreeNode;

public class SumRootToLeafNumbers {
    /*
        Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
        An example is the root-to-leaf path 1->2->3 which represents the number 123.
        Find the total sum of all root-to-leaf numbers.
    */
    public int sumNumbers(TreeNode root) {
        return recursive(root, 0);
    }

    private int recursive(TreeNode node, int base) {
        if (node == null) return 0;
        int currentSum = base * 10 + node.val;
        if (node.left == null && node.right == null) return currentSum;
        int leftSum = recursive(node.left, currentSum);
        int rightSum = recursive(node.right, currentSum);
        return leftSum + rightSum;
    }
}
