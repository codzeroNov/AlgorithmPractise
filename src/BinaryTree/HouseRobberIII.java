package BinaryTree;

import com.zzy.TreeNode;

import java.util.HashMap;

public class HouseRobberIII {
    /*
    The thief has found himself a new place for his thievery again.
    There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house.
    After a tour, the smart thief realized that "all houses in this place forms a binary tree".
    It will automatically contact the police if two directly-linked houses were broken into on the same night.
    Determine the maximum amount of money the thief can rob tonight without alerting the police.
     */

    // top to bottom dp, with memorization
    // https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
    HashMap<TreeNode, Integer> map = new HashMap();
    public int rob(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);

        int val = 0;
        if (node.left != null)
            val += helper(node.left.left) + helper(node.left.right);

        if (node.right != null)
            val += helper(node.right.left) + helper(node.right.right);

        val = Math.max(val + node.val, helper(node.left) + helper(node.right));
        map.put(node, val);

        return val;
    }

    // greedy
    // res[0] means we rob current node, while res[1] means we don't
    public int rob2(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode node) {
        int[] res = new int[2];
        if (node == null) return res;

        int[] left = robSub(node.left);
        int[] right = robSub(node.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];

        return res;
    }
}
