package algo.array;

/**
 * 2数字相加
 * @author chahelagan
 * @date 20191222
 */
public class AddTwoNumbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /***
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1 1
     * @param l2 2
     * @return result.head
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //结果连标head
        ListNode result = null;
        //是否进阶
        boolean flag = false;
        //当前需要add 的前一个节点  pre.next=current
        ListNode pre = null;
        //当前需要add 的节点
        ListNode current;
        while(l1 != null || l2 != null){
            current = new ListNode(-1);
            int lvalue = (l1 != null) ? l1.val : 0;
            int rvalue = (l2 != null) ? l2.val : 0;
            int resultValue = lvalue + rvalue;

            //可能 89 + 1
            if (flag) {
                resultValue ++;
                flag = false;
            }
            if (resultValue >= 10){
                flag = true;
                resultValue = resultValue - 10;
            }

            current.val = resultValue;
            if (result == null){
                result = current;
            }else{
                pre.next = current;
            }
            // 每次你新增的current 就是下一个需要处理的节点
            pre = current;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        // 可能 9 + 1
        if (flag){
            pre.next  = new ListNode(1);
        }
        return result;
    }

    /**
     * 如果不是逆序存储呢？长度不一样先不考虑了
     * (3→4→2)+(4→6→5)=8→0→7
     * @param l1 one
     * @param l2 two
     * @return result
     */
    private static ListNode addTwoNumbersNormalSeq(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode prev = result;

        while (l1 != null && l2 != null){
            int val = l1.val + l2.val;
            if(val > 9){
                prev.val += 1;
            }
            l1 = l1.next;
            l2 = l2.next;
             prev.next = new ListNode(val > 9 ? val-10 : val);
            prev = prev.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode result = AddTwoNumbers.addTwoNumbers(l1, l2);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
