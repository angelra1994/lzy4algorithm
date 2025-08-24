import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 206.反转链表
 * <a href="https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-11.
 */
public class T0206_反转链表 {

    public static void main(String[] args) {
        T0206_反转链表 t = new T0206_反转链表();
        ListNode head = ListNode.buildList(new int[]{1, 2, 3, 4, 5});

        assertEquals(5, t.reverseList(head).val);
        assertEquals(4, t.reverseList(head).next.val);

    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
