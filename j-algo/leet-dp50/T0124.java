import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 124. 二叉树中的最大路径和
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-07.
 */
public class T0124 {

    public static void main(String[] args) {
        T0124 t = new T0124();
        TreeNode root = TreeNode.buildTreeLevelOrder(new int[]{-10,9,20,Integer.MIN_VALUE,Integer.MIN_VALUE,15,7});
        assertEquals(42, t.maxPathSum(root));

    }


    int sum =  Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return sum;
    }

    private int maxGain(TreeNode node) {
        if (null == node) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值, 剔除贡献值为负的情况
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);

        sum = Math.max(sum, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
