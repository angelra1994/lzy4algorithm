import java.util.HashMap;
import java.util.Map;

/**
 * brief: 138. 复制带随机指针的链表
 * <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-26.
 */
public class T0138_随机链表的复制 {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

//        static Node buildList(int[][] nums) {
//            Node head = new Node(nums[0][0]);
//            Node p = head;
//            for (int i = 1; i < nums.length; i++) {
//
//            }
//        }
    }
    public static void main(String[] args) {
        T0138_随机链表的复制 t = new T0138_随机链表的复制();
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // key 是旧链表中的节点，val是新链表中的节点
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        Node q;
        while (p != null) {
            q = map.get(p);
            q.next = map.get(p.next);
            q.random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }
}
