package algo.linkedlist;

/**
 * delete elem in a linked List eq to
 * @author chahelagan
 * @since 2020-1-22
 */
public class DeleteNodeInaLinkedList {
    public void deleteNodeCh(int val, ListNode head) {
        ListNode pre = null;
        while (head != null){
            if (head.val == val){
                if (pre != null){
                    pre.next = head.next;
                }
            }
            pre = head;
            head = head.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
