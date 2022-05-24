package BinaryTree;

import com.zzy.TreeNode;

import java.util.ArrayList;
import java.util.List;




public class UniqueBinarySearchTreesII {

    //Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.


    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();

        return genTree(1, n);
    }

    private List<TreeNode> genTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            //left subtree list
            List<TreeNode> lstl = genTree(start, i - 1);
            //right subtree list
            List<TreeNode> rstl = genTree(i + 1, end);
            for (TreeNode left : lstl) {
                for (TreeNode right : rstl) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }

        return list;
    }
}
