import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 2. 两数相加
 * <a href="https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-13.
 */
public class T0002 {
    public static void main(String[] args) {
        T0002 t = new T0002();
        assertEquals(7, t.addTwoNumbers(ListNode.buildList(new int[]{2, 4, 3}), ListNode.buildList(new int[]{5, 6, 4})).val);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        int carry = 0;
        int sum = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }


        return dummy.next;

    }
}
