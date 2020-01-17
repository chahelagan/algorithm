package algo.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Stack;

/**
 * MaximumDepthOfBinaryTree
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author chahelagan
 * @since 2020-1-12
 */
public class MaximumDepthOfBinaryTree {
    /**
     * bfs
     * @param root root
     * @return max depth
     */
    public int maxDepthBfs(TreeNode root){
        int maxDepth = 0;
        if (root == null){
            return maxDepth;
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
            while (currentLevelNodeCount > 0) {
                // get node from  queue
                TreeNode current = treeNodeLinkedList.pollFirst();
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

            maxDepth ++;
            // continue Traversal next level nodes
            currentLevelNodeCount = treeNodeLinkedList.size();
        }

        return maxDepth;
    }

    /**
     * dfs
     * @param root root
     * @return max depth
     */
    public int maxDepthDfs(TreeNode root){
        int maxDepth = 0;
        if (root == null){
            return maxDepth;
        }
        Integer depth = 1;
        Stack<Pair<TreeNode, Integer>> treeNodeLinkedList = new Stack<>();

        TreeNode current = root;
        while (current != null){
            System.out.println(current.val);

            if (current.left != null && current.right != null){
                depth ++;
                treeNodeLinkedList.add(new Pair<>(current.right, depth));
                current = current.left;
            }else if (current.left == null && current.right == null){
                maxDepth = Math.max(maxDepth, depth);
                if (treeNodeLinkedList.isEmpty()){
                    break;
                }else{
                    Pair<TreeNode, Integer> treeNodeIntegerPair = treeNodeLinkedList.pop();
                    current = treeNodeIntegerPair.getKey();
                    depth = treeNodeIntegerPair.getValue();
                }
            }else{
                if (current.left != null){
                    depth ++;
                    current = current.left;
                }else{
                    depth ++;
                    current = current.right;
                }
            }
        }


        return maxDepth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new MaximumDepthOfBinaryTree().maxDepthDfs(root));
    }
}
