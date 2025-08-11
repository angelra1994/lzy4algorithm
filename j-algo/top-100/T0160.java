import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * brief: 160. 相交链表
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-09.
 */
public class T0160 {

    public static void main(String[] args) {
        T0160 t = new T0160();
        ListNode l1 = ListNode.build(new int[]{4, 1});
        ListNode l2 = ListNode.build(new int[]{5, 0, 1, 8});
        assertNull(t.getIntersectionNode1(l1, l2));
        assertNull(t.getIntersectionNode(l1, l2));
        ListNode l3 = ListNode.build(new int[]{6, 0, 1});
        ListNode.concat(l1, l3);
        ListNode.concat(l2, l3);
        assertEquals(6, t.getIntersectionNode1(l1, l2).val);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)  {
            return null;
        }
        // 遍历 PA -> A+B
        // 遍历 PB -> B+A
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)  {
            return null;
        }
        int lenA = 0, lenB = 0;
        ListNode pA = headA, pB = headB;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }

        // 对齐二者长度
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
