package BinaryTree;

import com.zzy.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandPostorderTraversal {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || pre.length == 0) return null;

        HashMap<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }

        return helper(pre, 0, pre.length-1, post, 0, post.length-1, postMap);
    }

    private TreeNode helper(int[] pre, int preS, int preE, int[] post, int postS, int postE, HashMap<Integer, Integer> postMap) {
        if (preS > preE || postS > postE) return null;
        TreeNode root = new TreeNode(pre[preS]);
        if (preS + 1 <= preE) {
            int idx = postMap.get(pre[preS+1]);
            root.left = helper(pre, preS + 1, preS + 1 + idx - postS, post, postS, idx, postMap);
            root.right = helper(pre, preS + 1 + idx - postS + 1, preE, post, idx + 1, postE - 1, postMap);
        }
        return root;
    }

}
