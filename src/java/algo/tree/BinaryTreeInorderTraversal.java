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
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        TreeNode pre = root;
        while (root != null) {
            if (root.left != null) {
                pre = root;
                root = root.left;
            } else {
                resultList.add(root.val);
                if (pre.right == null) {
//                   resultList.add()
                }else {
                    root = pre.right;
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = BinaryTreeInorderTraversal.buildTree(nodes);
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(root));
    }

    /**
     * build tree from array
     * @param nodes nodes info
     * @return tree root
     */
    private static TreeNode buildTree(Integer[] nodes){
        List<TreeNode> nodeList = new ArrayList<>();
        for (Integer node : nodes){
            TreeNode treeNode = new TreeNode(node);
            nodeList.add(treeNode);
        }
        for (int i = 0; i < nodes.length / 2 - 1; i++) {
            nodeList.get(i).left = nodeList.get(2 * i + 1);
            if (2 * i + 2 < nodes.length) {
                nodeList.get(i).right = nodeList.get(2 * i + 2);
            }
        }

        return nodeList.get(0);
    }
}
