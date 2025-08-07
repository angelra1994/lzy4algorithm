import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 103. 二叉树的锯齿形层序遍历
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">...</a>
 * Created by lzy on 2025-08-07.
 */
public class T0103 {

    public static void main(String[] args) {
        T0103 t = new T0103();
        TreeNode root = TreeNode.buildTreeLevelOrder(new int[]{3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7});
        assertEquals(List.of(List.of(3), List.of(20, 9), List.of(15, 7)), t.zigzagLevelOrder(root));
        root = TreeNode.buildTreeLevelOrder(new int[]{1});
        assertEquals(List.of(List.of(1)), t.zigzagLevelOrder(root));
        root = TreeNode.buildTreeLevelOrder(new int[]{});
        assertEquals(List.of(), t.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int j = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList();
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                if (j % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            j++;
            ans.add(list);
        }
        return ans;
    }
}
