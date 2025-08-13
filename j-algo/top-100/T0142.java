import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 142. 环形链表 II
 *<a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-12.
 */
public class T0142 {
    public static void main(String[] args) {
        T0142 t = new T0142();


        assertEquals(2, t.detectCycle1(ListNode.buildCycleList(new int[]{3, 2, 0, -4}, 1)).val);
        assertEquals(2, t.detectCycle(ListNode.buildCycleList(new int[]{3, 2, 0, -4}, 1)).val);
        assertEquals(3, t.detectCycle(ListNode.buildCycleList(new int[]{3, 2}, 0)).val);
    }

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // slow走了b步,，fast走了2b步。比slow多走了k圈  2b = b + kc => b = kc
            // slow从入环口，在环中走了b-a=kc-a 到达相遇点。即slow从相遇点开始，再走a步，就可到入环口
            if (slow == fast) {
                while (head != slow) { // slow再走a步，可到入环口
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }
}
