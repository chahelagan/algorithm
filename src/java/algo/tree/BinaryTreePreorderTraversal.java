package algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * BinaryTreePreorderTraversal
 * @author chahe
 * @since 2020-1-17
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> resultList = new LinkedList<>();
        if (root == null){
            return resultList;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.isEmpty()){
            TreeNode pop = nodes.pop();
            resultList.add(pop.val);

            if (pop.right != null){
                nodes.push(pop.right);
            }
            if (pop.left != null){
                nodes.push(pop.left);
            }
        }

        return resultList;
    }
}
