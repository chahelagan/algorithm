package algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * @author chahe
 * @since 2020-1-8
 */
public class BinaryTreeInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 不破坏树的结构
     * @param root root
     * @return result
     */
    public List <Integer> inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * 当发现单个变量满足不了要求的时候 是时候考虑引入数据结构了  破坏了树的结构
     * @param root root
     * @return result
     */
    private List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                treeNodeStack.push(current);
                current = current.left;
            } else {
                resultList.add(current.val);
                if (current.right == null) {
                    if (treeNodeStack.isEmpty()){
                        break;
                    }
                    TreeNode pre = treeNodeStack.pop();
                    // 已经遍历过了 所以改了原有树的结构
                    pre.left = null;
                    current = pre;
                }else {
                    current = current.right;
                }
            }
        }

        return resultList;
    }

    /**
     * 莫里斯中序遍历
     * @return result
     */
    private List<Integer> morrisTraverMid(TreeNode root){
        List<Integer> resultList = new ArrayList<>();
        TreeNode current = root;
        TreeNode pre = root;
        TreeNode temp = root;
        while (current != null){
            if (current.left == null){
                resultList.add(current.val);
                // move to next right node
                current = current.right;
            }else{
                // has a left child
                temp = current.left;
                // find rightmost
                while (temp.right != null){
                    temp = temp.right;
                }
                // 设置 最右节点有孩子为当前节点
                temp.right = current;
                // 存储current node
                pre = current;
                // 移动current 到 新树的 root
                current = current.left;
                // 设置 原有 current 的左节点为null 避免死循环
                pre.left = null;
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
//        int[] nodes = new int[]{1,0,2,3};
//        TreeNode root = BinaryTreeInorderTraversal.buildTree(nodes);
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode node2 = new TreeNode(2);
        root.right = node2;
        node2.left = new TreeNode(3);
        System.out.println(new BinaryTreeInorderTraversal().morrisTraverMid(root));
    }

    /**
     * build tree from array
     * @param nums nodes info
     * @return tree root
     */
    private static TreeNode buildTree(int[] nums){
        List<TreeNode> nodeList = new ArrayList<>();
        for (Integer node : nums){
            TreeNode treeNode = new TreeNode(node);
            nodeList.add(treeNode);
        }
        for (int i = 0; i <= nums.length / 2 - 1; i++) {
            nodeList.get(i).left = nodeList.get(2 * i + 1);
            if (2 * i + 2 < nums.length) {
                nodeList.get(i).right = nodeList.get(2 * i + 2);
            }
        }

        return nodeList.get(0);
    }
}
