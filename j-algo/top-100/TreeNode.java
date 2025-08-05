import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeInLevelOrder(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < levelOrder.length)  {
            TreeNode node = q.poll();
            // 处理左子节点
            if (i < levelOrder.length) {
                if (levelOrder[i] != -1) {
                    node.left = new TreeNode(levelOrder[i]);
                    q.offer(node.left);
                }
                i++;
            }

            // 处理右子节点
            if (i < levelOrder.length) {
                if (levelOrder[i] != -1) {
                    node.right = new TreeNode(levelOrder[i]);
                    q.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }
}