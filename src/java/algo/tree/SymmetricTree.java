package algo.tree;

import java.util.LinkedList;

/**
 *　给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
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
 *
 * @author chahe
 * @since 2020-1-17
 */
public class SymmetricTree {

    /**
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add()

        while (!nodes.isEmpty()){
            while (currentLevelCount -- > 0){
                TreeNode pop = nodes.pop();
                if (pop != null){
                    valueList.add(pop.val);
                }else{
                    valueList.add(null);
                }

                if (pop != null && (pop.left != null || pop.right != null)){
                    if (pop.left != null){
                        nodes.push(pop.left);
                        nodes.push(null);
                    }
                    if (pop.right != null){
                        nodes.push(null);
                        nodes.push(pop.right);
                    }
                }
            }

            for (int i = 0; i < valueList.size() / 2; i++) {
                if (valueList.get(i) != valueList.get(valueList.size() - i)){

                }
            }

            valueList.clear();
            currentLevelCount = nodes.size();
        }

        return true;
    }
}
