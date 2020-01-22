package algo.linkedlist;

/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author chahelagan
 * @since 2020-1-22
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // 这个 temp 指向 head 有点意思
        ListNode temp = new ListNode(-1);
        temp.next = head;
        // 因为 pre.next 要指向 相互交换的第二个节点
        ListNode pre = temp;

        ListNode current = head;
        while (current != null && current.next != null){
            // 第一个是 current 第二个是 current.next
            ListNode sec = current.next;
            // swap a(奇数节点) and  b(偶数节点)
            current.next = sec.next;
            sec.next = current;
            // pre.next -> b 偶数节点
            pre.next = sec;

            pre = current;
            current = current.next;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        new SwapNodesInPairs().swapPairs(root);
    }
}
