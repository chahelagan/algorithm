package algo.tree;

import java.util.Stack;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * @author chahe
 * @since 2020-1-16
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()){
            TreeNode[] pop = stack.pop();

            if (pop[0] != null && pop[2] != null){
                pop[0].val = pop[0].val + pop[1].val;
            }
        }

        return t1;
    }

    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(1);
//        root1.left = new TreeNode(3);
//        root1.right = new TreeNode(2);
//        root1.left.left = new TreeNode(5);
//
//        TreeNode root2 = new TreeNode(2);
//        root2.left = new TreeNode(1);
//        root2.right = new TreeNode(3);
//        root2.left.right = new TreeNode(4);
//        root2.right.right = new TreeNode(7);


//        TreeNode root1 = new TreeNode(1);
//
//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(2);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = null;
        root1.left.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = null;
        root2.right = new TreeNode(2);
        root2.right.left = null;
        root2.right.right = new TreeNode(3);

        new MergeTwoBinaryTrees().mergeTrees(root1, root2);
    }
}
