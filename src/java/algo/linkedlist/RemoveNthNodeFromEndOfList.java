package algo.linkedlist;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 * Could you do this in one pass?
 * @author chahelagan
 * @since 2020-1-22
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        // 先 指针2 向前移动 n 步 和 指针1保持 n 的距离 即可 当指针2 移动到尾的时候 指针1就是pre
        ListNode nextN = head;
        for (int i = 0; i < n; i++) {
            nextN = nextN.next;
        }
        // [1],1  [2,1],2 异常情况
        if (nextN == null){
            return head.next;
        }

        while (current.next != null && nextN.next != null){
            current = current.next;
            nextN = nextN.next;
        }
        current.next = current.next.next;

        return head;
    }
}
