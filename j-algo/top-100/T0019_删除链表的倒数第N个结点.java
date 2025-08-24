import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 19.删除链表的倒数第 N 个结点
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-13.
 */
public class T0019_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        T0019_删除链表的倒数第N个结点 t = new T0019_删除链表的倒数第N个结点();
        assertEquals(2, t.removeNthFromEnd(ListNode.buildList(new int[]{1, 2}), 2).val);
        assertEquals(2, t.removeNthFromEnd1(ListNode.buildList(new int[]{1, 2}), 2).val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // 让快的先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        int target = count - n + 1;
        ListNode curr = dummy;
        for (int i =1; i<target;i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;


        return dummy.next;

    }
}
