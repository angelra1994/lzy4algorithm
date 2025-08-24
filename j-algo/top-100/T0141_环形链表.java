import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * brief: 141. 环形链表
 * <a href="https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-12.
 */
public class T0141_环形链表 {
    public static void main(String[] args) {
        T0141_环形链表 t = new T0141_环形链表();
        ListNode l1 = ListNode.buildCycleList(new int[]{3, 2, 0, -4}, 1);
        assertTrue(t.hasCycle(l1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快的追上慢的，说明有环，兔子超过乌龟一圈或者多圈
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
