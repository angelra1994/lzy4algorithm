import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 199 二叉树的右视图
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-07.
 */
public class T0199 {
    public static void main(String[] args) {
        T0199 t = new T0199();
        TreeNode root = TreeNode.buildTreeLevelOrder(new String[]{"1", "2", "3", TreeNode.NULL_NODE, "5", TreeNode.NULL_NODE, "4"});
        assertEquals(3, t.rightSideView(root).size());
        assertEquals(3, t.rightSideView(root).get(1));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // list.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (i == size - 1) {
                    ans.add(node.val);
                }
            }
//            ans.add(list.get(list.size() -1));
        }
        return ans;
    }
}
