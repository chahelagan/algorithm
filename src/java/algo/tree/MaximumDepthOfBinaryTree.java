package algo.tree;

import java.util.Stack;

/**
 *
 * @author chahelagan
 * @since 2020-1-12
 */
public class MaximumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root){
        int maxDepth = 1;
        int temp = 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null){
            if (current.left != null){
                stack.push(current.right);
                current = current.left;
                temp++;
            }else{
                if (current.right == null){
                    maxDepth = Math.max(maxDepth, temp);
                }else{
                    current = current.right;
                }
            }
        }


        return maxDepth;
    }
}
