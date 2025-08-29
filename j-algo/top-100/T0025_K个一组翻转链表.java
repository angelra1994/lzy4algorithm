/**
 * brief: 25. K 个一组翻转链表
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-29.
 */
public class T0025_K个一组翻转链表 {
    public static void main(String[] args) {
        T0025_K个一组翻转链表 t = new T0025_K个一组翻转链表();
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表中节点个数
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode prev = null;
        ListNode next = null;

        // k个一组处理，并且链表长度大于k才进行翻转处理
        while (n >= k) {
            n = n -k;
            for (int i = 0; i < k; i++) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            next = p0.next;
            p0.next.next = head;
            p0.next = prev;
            p0 = next;
        }

        return dummy.next;
    }
}
