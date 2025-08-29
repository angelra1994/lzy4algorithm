import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 92. 反转链表 II
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/">...</a>
 * Created by lzy on 2025-08-25.
 */
public class T0092_反转链表II {

    public static void main(String[] args) {
        T0092_反转链表II t = new T0092_反转链表II();
        assertEquals(3, t.reverseBetween(ListNode.buildList(new int[]{1, 2, 4, 3, 5}), 2, 4).next.val);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        head = p0.next;
        ListNode prev = null;
        ListNode next = null;
        //1(p0)->2(head)->3->4->5
        for (int i = 0; i < right - left + 1; i++) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        //1(p0)->2<-3<-4(prev) 5(head)

        p0.next.next = head;
        //1(p0)->2<-3<-4(prev)
        //       |-> 5(head)
        p0.next = prev;
        // 1(p0)->4(prev)->3->2->5(head)
        return dummy.next;
    }
}
