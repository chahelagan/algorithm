package algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chahelagan
 * @since 2020-1-12
 */
public class NaryTreePreOrderTraversal {
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
    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null){
            resultList.add(current.val);
            if (current.children != null && current.children.size() > 0){
                for (int i = current.children.size() - 1; i > 0; i--) {
                    stack.push(current.children.get(i));
                }
                current = current.children.get(0);
            }else{
                if (stack.isEmpty()){
                    break;
                }else{
                    current = stack.pop();
                }
            }
        }

        return resultList;
    }
}
