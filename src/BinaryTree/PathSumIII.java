package BinaryTree;

import com.zzy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    /*
    You are given a binary tree in which each node contains an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     */

    /**
     * 1. The prefix stores the sum from the root to the current node in the recursion
     * 2. The map stores <prefix sum, frequency> pairs before getting to the current node. We can imagine a path from the root to the current node. The sum from any node in the middle of the path to the current node = the difference between the sum from the root to the current node and the prefix sum of the node in the middle.
     * 3. We are looking for some consecutive nodes that sum up to the given target value, which means the difference discussed in 2. should equal to the target value. In addition, we need to know how many differences are equal to the target value.
     * 4. Here comes the map. The map stores the frequency of all possible sum in the path to the current node. If the difference between the current sum and the target value exists in the map, there must exist a node in the middle of the path, such that from this node to the current node, the sum is equal to the target value.
     * 5. Note that there might be multiple nodes in the middle that satisfy what is discussed in 4. The frequency in the map is used to help with this.
     * 6. Therefore, in each recursion, the map stores all information we need to calculate the number of ranges that sum up to target. Note that each range starts from a middle node, ended by the current node.
     * 7. To get the total number of path count, we add up the number of valid paths ended by EACH node in the tree.
     * 8. Each recursion returns the total count of valid paths in the subtree rooted at the current node. And this sum can be divided into three parts:
     * - the total number of valid paths in the subtree rooted at the current node's left child
     * - the total number of valid paths in the subtree rooted at the current node's right child
     * - the number of valid paths ended by the current node
     * **/
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefix = new HashMap<>(); // stores <prefix sum, frequency>
        prefix.put(0, 1);
        return dfs(root, prefix, sum, 0);
    }

    private int dfs(TreeNode node, Map<Integer, Integer> prefix, int target, int currSum) {
        if (node == null) return 0;

        currSum += node.val;
        int res = prefix.getOrDefault(currSum - target, 0);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);

        res += dfs(node.left, prefix, target, currSum) + dfs(node.right, prefix, target, currSum);
        prefix.put(currSum, prefix.get(currSum) - 1);
        return res;
    }
}
