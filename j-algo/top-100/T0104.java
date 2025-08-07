import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 104.二叉树的最大深度
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-06.
 */
public class T0104 {
    public static void main(String[] args) {
        T0104 t = new T0104();
        TreeNode root = TreeNode.buildTreeLevelOrder(new int[]{3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7});
        assertEquals(3, t.maxDepth(root));

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
