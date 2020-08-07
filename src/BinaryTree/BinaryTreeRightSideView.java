package BinaryTree;

import com.zzy.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    //Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

    //bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);

                if (i == size - 1)
                    res.add(node.val);
            }
        }

        return res;
    }

    //dfs
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        rightView(root, res, 0);
        return res;
    }

    private void rightView(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        if (level == res.size()) res.add(node.val);
        rightView(node.right, res, level + 1);
        rightView(node.left, res, level + 1);
    }



}
