package algo.linkedlist;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * @author chahelagan
 * @since 2020-1-22
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    /**
     * 递归版本
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}
