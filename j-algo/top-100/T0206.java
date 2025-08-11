import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief:
 * Created by lzy on 2025-08-11.
 */
public class T0206 {

    public static void main(String[] args) {
        T0206 t = new T0206();
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ;
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
