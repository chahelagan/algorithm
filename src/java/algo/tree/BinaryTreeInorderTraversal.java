package algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * @author chahe
 * @since 2020-1-8
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        TreeNode pre = null;
        while (root != null) {
            if (root.left != null) {
                pre = root;
                root = root.left;
            } else {
                resultList.add(root.val);
                root = pre;
            }
        }

        return resultList;
    }

    public static void main(String[] args) {

    }
}
