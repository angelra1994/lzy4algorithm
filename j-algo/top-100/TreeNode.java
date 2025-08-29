import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public static final String NULL_NODE = "null";
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

    // 满足一定条件才可以通过数组生成二叉树
    public static TreeNode buildTreeLevelOrder(String[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || NULL_NODE.equals(levelOrder[0])) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(levelOrder[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < levelOrder.length) {
            TreeNode node = q.poll();
            // 处理左子节点
            if (i < levelOrder.length) {
                if (!NULL_NODE.equals(levelOrder[i])) {
                    node.left = new TreeNode(Integer.parseInt(levelOrder[i]));
                    q.offer(node.left);
                }
                i++;
            }

            // 处理右子节点
            if (i < levelOrder.length) {
                if (!NULL_NODE.equals(levelOrder[i]))
                    node.right = new TreeNode(Integer.parseInt(levelOrder[i]));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }

    // 满足一定条件才可以通过数组生成二叉树
    public static TreeNode buildTreeLevelOrder(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == Integer.MIN_VALUE) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < levelOrder.length) {
            TreeNode node = q.poll();
            // 处理左子节点
            if (i < levelOrder.length) {
                if (levelOrder[i] != Integer.MIN_VALUE) {
                    node.left = new TreeNode(levelOrder[i]);
                    q.offer(node.left);
                }
                i++;
            }

            // 处理右子节点
            if (i < levelOrder.length) {
                if (levelOrder[i] != Integer.MIN_VALUE) {
                    node.right = new TreeNode(levelOrder[i]);
                    q.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    // 满足一定条件才可以通过数组生成二叉树。左根右
    public static TreeNode buildTreeInOrder(int[] order, int[] startIndex) {
        if (order == null || startIndex[0] >= order.length || order[startIndex[0]] == -1) {
            startIndex[0]++;
            return null;
        }
        TreeNode root = new TreeNode(order[startIndex[0] + 1]);
        root.left = buildTreeInOrder(order, startIndex);

//        startIndex[0] = startIndex[0] +2 ;  // 使用包装数组来模拟引用传递，避免使用类级别变量
//        root.right = buildTreeInOrder(order, startIndex);
        return root;

    }

}