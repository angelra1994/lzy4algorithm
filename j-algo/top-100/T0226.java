import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 226.翻转二叉树
 * <a href="https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-06.
 */
public class T0226 {
    public static void main(String[] args) {
        T0226 t = new T0226();
        TreeNode root = TreeNode.buildTreeLevelOrder(new int[]{4, 2, 7, 1, 3, 6, 9});
        TreeNode res = t.invertTree(root);
        assertEquals(7, res.left.val);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
