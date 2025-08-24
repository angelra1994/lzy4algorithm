import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 21. 合并两个有序链表
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-13.
 */
public class T0021_合并两个有序链表 {

    public static void main(String[] args) {
        T0021_合并两个有序链表 t = new T0021_合并两个有序链表();
        assertEquals(0, t.mergeTwoLists(ListNode.buildList(new int[]{0, 2, 4}), ListNode.buildList(new int[]{1, 3, 4})).val);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
