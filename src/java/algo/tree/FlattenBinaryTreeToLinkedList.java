package algo.tree;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * @author chahelagan
 * @since 2020-1-19
 */
public class FlattenBinaryTreeToLinkedList {
    /**
     * 1. current.left -> current.right
     * 2. right tree -> max right Node.right
     * 3. next = current.right
     * @param root tree root
     */
    public void flatten(TreeNode root) {
        while (root != null){
            if (root.left == null){
                root = root.right;
            }else {
                TreeNode right = root.right;
                root.right = root.left;
                // left = null
                root.left = null;

                TreeNode pre = root.right;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = right;

                root  = root.right;
            }
        }
    }
}
