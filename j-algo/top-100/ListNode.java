public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode buildList(int[] nums) {
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
    public static ListNode buildCycleList(int[] nums, int pos) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (pos < 0 || pos >= nums.length) {
            return buildList(nums);
        }
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        ListNode current = sentinel;
        ListNode cycleStartNode = null;
        ListNode tailNode = null;

        for (int i = 0; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            current.next = newNode;
            current = newNode;

            if (i == pos) {
                cycleStartNode = newNode;
            }
            if (i == nums.length - 1) {
                tailNode = newNode;
            }
        }

        if (tailNode != null && cycleStartNode != null) {
            tailNode.next = cycleStartNode;
        }

        return sentinel.next;
    }

    public static void concat(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        ListNode prev = null;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            return;
        }
        prev.next = l2;
    }
}