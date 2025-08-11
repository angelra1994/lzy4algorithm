public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode build(int[] nums) {
        if (nums == null ||  nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public static ListNode concat(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        ListNode prev = null;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = l2;
        return l1;
    }
}