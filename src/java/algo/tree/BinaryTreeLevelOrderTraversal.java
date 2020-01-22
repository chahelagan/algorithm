package algo.tree;


import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层次遍历例如:
 *
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author chahe
 * @since 2020-1-14
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * bfs
     * @param root root
     * @return result
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();
        if (root == null){
            return resultList;
        }
        /*当前 level node count */
        int currentLevelNodeCount = 0;
        LinkedList<TreeNode> treeNodeLinkedList = new LinkedList<>();
        // add root -> current node
        treeNodeLinkedList.add(root);
        // root level node count ++
        currentLevelNodeCount ++;

        // when has node to Traversal
        while (!treeNodeLinkedList.isEmpty()) {
            // current level nodes List
            List<Integer> currentLevelNodes = new LinkedList<>();
            while (currentLevelNodeCount > 0) {
                // get node from  queue
                TreeNode current = treeNodeLinkedList.pollFirst();
                currentLevelNodes.add(current.val);
                currentLevelNodeCount--;

                // push next level child to queue
                TreeNode left = current.left;
                TreeNode right = current.right;
                if (left != null) {
                    treeNodeLinkedList.add(left);
                }
                if (right != null) {
                    treeNodeLinkedList.add(right);
                }
            }

            // add current level nodes to list
            resultList.add(currentLevelNodes);
            // continue Traversal next level nodes
            currentLevelNodeCount = treeNodeLinkedList.size();
        }

        return resultList;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();
        if (root == null){
            return resultList;
        }
        LinkedList<LinkedList<Integer>> tempList = new LinkedList<>();
        int currentLevelNodeCount = 0;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        currentLevelNodeCount ++;

        while (!nodes.isEmpty()){
            LinkedList currentLevelNodes = new LinkedList();
            while (currentLevelNodeCount -- > 0){
                TreeNode current = nodes.pop();
                currentLevelNodes.add(current.val);

                if (current.left != null){
                    nodes.add(current.left);
                }
                if (current.right != null){
                    nodes.add(current.right);
                }
            }
            currentLevelNodeCount = nodes.size();
            tempList.addFirst(currentLevelNodes);
        }
        resultList.addAll(tempList);

        return resultList;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }
}
