package algo.tree;

import java.util.Stack;

/**
 * Invert Binary Tree
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author chahe
 * @since 2020-1-16
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);


        while (!nodes.isEmpty()){
            TreeNode current = nodes.pop();
            // swap
            if (current.left != null || current.right != null){
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;

                if (current.left != null){
                    nodes.push(current.left);
                }
                if (current.right != null){
                    nodes.push(current.right);
                }
            }
        }


        return root;
    }

    public static void main(String[] args) {

    }
}
