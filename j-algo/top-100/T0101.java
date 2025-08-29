import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * brief: 101. 对称二叉树
 * <a href="https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-06.
 */
public class T0101 {
    public static void main(String[] args) {
        T0101 t = new T0101();
        TreeNode root = TreeNode.buildTreeLevelOrder(new String[]{"1", "2", "2", "3", "4", "4", "3"});
        assertTrue(t.isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
