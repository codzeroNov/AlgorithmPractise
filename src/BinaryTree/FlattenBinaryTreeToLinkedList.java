package BinaryTree;

import com.zzy.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                //find left subtree's most right node
                TreeNode leftSubTreeMostRight = root.left;
                while (leftSubTreeMostRight.right != null)
                    leftSubTreeMostRight = leftSubTreeMostRight.right;

                //merge root's right tree
                leftSubTreeMostRight.right = root.right;
                root.right = root.left;
                root.left = null;

                //go next
                root = root.right;
            }
        }
    }

}
