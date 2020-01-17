package algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * BinaryTreePostorderTraversal
 *
 * @author chahe
 * @since 2020-1-17
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> resultList = new LinkedList<>();
        if (root == null){
            return resultList;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode current = nodes.pop();
            //　主要是这个 addFirst 先把要最后遍历到的　元素先取出来　addFirst
            resultList.addFirst(current.val);

            if (current.left != null){
                nodes.push(current.left);
            }

            if (current.right != null){
                nodes.push(current.right);
            }
        }

        return resultList;
    }
}
