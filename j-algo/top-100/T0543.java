import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 543. 二叉树的直径
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-07.
 */
public class T0543 {
    int ans = 0;

    public static void main(String[] args) {
        T0543 t = new T0543();
        TreeNode root = TreeNode.buildTreeLevelOrder(new String[]{"1", "2", "3", "4", "5"});
        assertEquals(3, t.diameterOfBinaryTree(root));

        root = TreeNode.buildTreeLevelOrder(new String[]{"1", "2"});
        assertEquals(1, t.diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        // 左子树的深度 + root和左孩子的高层差
        int left = depth(root.left) + 1;
        // 右子树的深度 + root和右孩子的高层差
        int right = depth(root.right) + 1;
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
