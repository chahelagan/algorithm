package algo.tree;

import java.util.LinkedList;

/**
 * 二叉树的最小深度
 * @author chahe
 * @since 2020-1-17
 */
public class MinimumDepthofBinaryTree {
    /**
     * bfs
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int currentLevelNodeCount = 1;
        int minDepth = 1;

        while (!nodes.isEmpty()){
            while (currentLevelNodeCount-- > 0){
                TreeNode pop = nodes.pop();

                // push next level nodes
                if (pop.left != null){
                    nodes.add(pop.left);
                }

                if (pop.right != null){
                    nodes.add(pop.right);
                }

                if (pop.left == null && pop.right == null){
                    return minDepth;
                }
            }

            minDepth ++;
            currentLevelNodeCount = nodes.size();
        }

        return minDepth;
    }
}
