import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 24. 两两交换链表中的节点
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-24.
 */
public class T0024_两两交换链表中的节点 {
    public static void main(String[] args) {
        T0024_两两交换链表中的节点 t = new T0024_两两交换链表中的节点();
        ListNode l1 = ListNode.buildList(new int[]{1, 2, 3, 4});
        assertEquals(2, t.swapPairs(l1).val);
    }

    /**
     * dummy -> 1 -> 2 -> 3 -> 4
     *
     * |-----------⬇️
     * dummy   1 -> 2 -> 3 -> 4
     *
     * |------------⬇️
     * dummy   1 <=> 2   3 -> 4
     *
     * |-----------⬇️
     * dummy   1 <- 2   3 -> 4
     *         |--------⬆️
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode n0 = dummy;
        ListNode n1 = head;
        ListNode n2;
        ListNode n3;
        while (n1 != null && n1.next != null) {
            n2 = n1.next;
            n3 = n2.next;

            n0.next = n2;   // 0 -> 2
            n2.next = n1;   // 2 -> 1
            n1.next = n3;   // 1 -> 3

            n0 = n1;       // 下一轮交换，0 是 1
            n1 = n3;       // 下一轮交换，1 是 3
        }
        return dummy.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode n3 = head.next.next;

        n1.next = swapPairs1(n3);       // 1 指向递归返回的链表头
        n2.next = n1;                   // 2 指向 1

        return n2;
    }
}
