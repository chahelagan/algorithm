package algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chahelagan
 * @since 2020-1-12
 */
public class NaryTreePostOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    /**
     * 官方代码 比较整洁
     * @param root root
     * @return seq
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> resultList = new LinkedList<>();
        if (root == null){
            return resultList;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()){
            Node current = list.pollLast();
            resultList.addFirst(current.val);
            for (Node child : current.children){
                list.addLast(child);
            }
        }

        return resultList;
    }

    /**
     * chahe
     * @param root root
     * @return seq
     */
    public List<Integer> postorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node pre = root;
        while (current != null){
            if(current.children != null && current.children.size() > 0){
                //先把有孩子的节点压到stack下面
                stack.push(current);
                //把child 反向压入栈
                for (int i = current.children.size() - 1; i > 0; i--) {
                    stack.push(current.children.get(i));
                }
                pre = current;
                current = current.children.get(0);
            }else{
                resultList.add(current.val);
                if (stack.isEmpty()){
                    break;
                }
                current = stack.pop();
            }
            // 因为 pre的child 已经压入栈了 所以 设置成null 避免死循环ß
            pre.children = null;
        }

        return resultList;
    }
}
