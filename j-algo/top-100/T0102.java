import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 102. 二叉树的层序遍历
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-05.
 */
public class T0102 {
    public static void main(String[] args) {
        T0102 t = new T0102();

        TreeNode root = TreeNode.buildTreeLevelOrder(new int[]{3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7});
        assertEquals(3, t.levelOrder(root).size());
        assertEquals(3, t.levelOrder(root).get(0).get(0));

        root = TreeNode.buildTreeLevelOrder(new int[]{});
        assertEquals(0, t.levelOrder(root).size());

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)  {
            return ans;
        }
        Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.offer(root);
        while (!curLevel.isEmpty()) {
            int size = curLevel.size();
            List<Integer> curLevelVal = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = curLevel.poll();
                curLevelVal.add(node.val);
                if (node.left != null) {
                    curLevel.offer(node.left);
                }
                if (node.right != null) {
                    curLevel.offer(node.right);
                }
            }
            ans.add(curLevelVal);
        }
        return ans;
    }
}
