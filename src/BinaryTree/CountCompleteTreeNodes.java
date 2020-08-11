package BinaryTree;

import com.zzy.TreeNode;

public class CountCompleteTreeNodes {
    /*
        Given a complete binary tree, count the number of nodes.

        Note:
        In a complete binary tree every level, except possibly the last, is completely filled,
        and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
    */

    //space:O(N), time:O(d)=O(logN), d is the depth of tree
    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }

    //space
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;

        int d = calHeight(root);
        if (d == 0) return 1;

        int left = 0, right = (int) (Math.pow(2, d) - 1);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (exist(root, d, mid))
                left = mid + 1;
            else
                right = mid - 1;
        }

        return (int) (Math.pow(2, d) - 1 + left);
    }

    private boolean exist(TreeNode node, int d, int idx) {
        int left = 0, right = (int) (Math.pow(2, d) - 1);
        for (int i = 0; i < d; i++) {
            int mid = (left + right) / 2;
            if (idx <= mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }

        return node != null;
    }

    private int calHeight(TreeNode node) {
        return node == null ? 0 : 1 + calHeight(node.left);
    }

/*
    //another way
    public int calHeight(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }
*/

}
