import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * brief: 234.回文链表
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-11.
 */
public class T0234_回文链表 {

    public static void main(String[] args) {
        T0234_回文链表 t = new T0234_回文链表();

        assertTrue(t.isPalindrome1(ListNode.buildList(new int[] {1,2,3,4,3,2,1})));
        assertTrue(t.isPalindrome(ListNode.buildList(new int[] {1,2,3,4,3,2,1})));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> s = new Stack<>();
        while (fast != null && fast.next != null) {
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        // 遍历后半截，后半截的数据和stack中存的前半截数据对比
        while (slow != null) {
            if (slow.val != s.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
