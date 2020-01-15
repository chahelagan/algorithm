package algo.tree;

import java.util.LinkedList;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      /  \
 *    -3    9
 *    /     /
 *  -10 -1 5  11
 *
 * @author chahe
 * @since 2020-1-15
 */
public class ConvertSortedArrayToBinarySearchTree {
    class MyTreeNode{
        TreeNode treeNode;
        /** start 是当前节点的 left child 的下标*/
        int start;
        /** end 是当前节点的 right child 的下标*/
        int end;
        MyTreeNode(TreeNode node, int start, int end) {
            this.treeNode = node;
            this.start = start;
            this.end = end;
        }
    }

    /**
     * Bfs
     * @param nums nums
     * @return result
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(0);
        MyTreeNode myTreeNode = new MyTreeNode(root, 0 , nums.length - 1);
        LinkedList<MyTreeNode> nodes = new LinkedList<>();
        nodes.add(myTreeNode);

        while (!nodes.isEmpty()){
            MyTreeNode current = nodes.pop();
            int left = current.start;
            int right = current.end;
            int mid = (left + right) / 2;
            /* 设置 当前节点的 val */
            current.treeNode.val = nums[mid];

            /* 设置左孩子*/
            if (left < mid){
                TreeNode currentLeft = new TreeNode(0);
                current.treeNode.left = currentLeft;
                /* 设置左孩子的 左右孩子 下标*/
                nodes.add(new MyTreeNode(currentLeft, left, mid - 1));
            }
            if (right > mid){
                TreeNode currentRight = new TreeNode(0);
                current.treeNode.right = currentRight;
                nodes.add(new MyTreeNode(currentRight, mid + 1, right));
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);
        System.out.println(root);
    }
}
