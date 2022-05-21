package BinaryTree;

import com.zzy.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode leftSubtreeMostRight = curr.left;
                while (leftSubtreeMostRight.right != null)
                    leftSubtreeMostRight = leftSubtreeMostRight.right;

                leftSubtreeMostRight.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

}
