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

        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1, postMap);
    }

    private TreeNode helper(int[] pre, int preS, int preE, int[] post, int postS, int postE, HashMap<Integer, Integer> postMap) {
        if (preS > preE || postS > postE) return null;
        TreeNode root = new TreeNode(pre[preS]);
        if (preS == preE) return root;
        // pre[preS+1] as index indicates the next root, and we need next root to start building the sub-tree in the next round
        int idx = postMap.get(pre[preS + 1]);
        // for the root.left, the distance of postStart and postEnd stay constant because of the distance of preStart and preEnd stay constant
        root.left = helper(pre, preS + 1, preS + 1 + idx - postS, post, postS, idx, postMap);
        root.right = helper(pre, preS + 1 + idx - postS + 1, preE, post, idx + 1, postE - 1, postMap);

        return root;
    }


    /**
     * Create a node TreeNode(preorder[preIndex]) as the root.
     *
     * Because root node will be lastly iterated in post order,
     * if root.val == post[posIndex],
     * it means we have constructed the whole tree,
     *
     * If we haven't completed constructed the whole tree,
     * So we recursively constructFromPrePost for left subtree and right subtree.
     *
     * And finally, we'll reach the posIndex that root.val == post[posIndex].
     * We increment posIndex and return our root node.
     * **/
    int preidx = 0, postidx = 0;
    public TreeNode constructFromPrePost2(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preidx++]);
        if (root.val != postorder[postidx])
            root.left = constructFromPrePost2(preorder, postorder);

        if (root.val != postorder[postidx])
            root.right = constructFromPrePost2(preorder, postorder);

        postidx++;
        return root;
    }

}
