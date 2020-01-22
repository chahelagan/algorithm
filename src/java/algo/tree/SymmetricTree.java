package algo.tree;

import java.util.LinkedList;

/**
 *　给定一个二叉树，检查它是否是镜像对称的。
 *  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * @author chahe
 * @since 2020-1-17
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        /* 同时遍历*/
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(root);

        while (!nodes.isEmpty()){
            /* 要比较的2个节点必须在一起 不然会比较错误*/
            TreeNode first = nodes.pollFirst();
            TreeNode last = nodes.pollFirst();
            /* 叶子节点会丢 2个null 进来 跳过即可*/
            if (first == null && last == null) {
                continue;
            }
            if (first == null || last == null){
                return false;
            }
            if (first.val != last.val){
                return false;
            }
            /* 已需要比较的顺序入队列F*/
            nodes.add(first.left);
            nodes.add(last.right);
            nodes.add(first.right);
            nodes.add(last.left);
        }

        return true;
    }
}
