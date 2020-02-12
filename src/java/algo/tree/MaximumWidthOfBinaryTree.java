package algo.tree;

import java.util.LinkedList;

/**
 * 二叉树最大宽度
 * @author chahelagan
 * @since 2020-2-12
 */
public class MaximumWidthOfBinaryTree {
    static class AnnotatedNode {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }
    /**
     * bfs
     * @param root root
     * @return width
     */
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if (root == null){
            return maxWidth;
        }
        LinkedList<AnnotatedNode> treeNodeLinkedList = new LinkedList<>();
        // add root -> current node
        treeNodeLinkedList.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0;

        // when has node to Traversal
        while (!treeNodeLinkedList.isEmpty()) {
            // get node from queue
            AnnotatedNode current = treeNodeLinkedList.pollFirst();
            if (current.node != null) {
                treeNodeLinkedList.add(new AnnotatedNode(current.node.left, current.depth + 1, current.pos * 2));
                treeNodeLinkedList.add(new AnnotatedNode(current.node.right, current.depth + 1, current.pos * 2 + 1));
                if (curDepth != current.depth){
                    curDepth = current.depth;
                    left = current.pos;
                }
                maxWidth = Math.max(maxWidth, current.pos - left + 1);
            }
        }

        return maxWidth;
    }
}
