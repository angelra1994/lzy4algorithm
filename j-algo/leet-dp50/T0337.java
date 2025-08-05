import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 337.打家劫舍 III
 * <a href="https://leetcode.cn/problems/house-robber-iii/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-04.
 */
public class T0337 {
    public static void main(String[] args) {
        T0337 t = new T0337();

        TreeNode root = t.buildTreeInPreOrder(new int[]{3, 2, 3, -1, 3, -1, 1}, new int[]{0});
        System.out.println("inorder:");
        t.printTreeInPreorder(root);
        System.out.println();

        root = t.buildTreeInLevelOrder(new int[]{3, 2, 3, -1, 3, -1, 1});
        System.out.println("levelOrder");
        t.printTreeInLevelOrder(root);
        System.out.println();
        assertEquals(7, t.rob(root));

        root = t.buildTreeInPreOrder(new int[]{3, 4, 5, 1, 3, -1, 1}, new int[]{0});
        System.out.println("inorder:");
        t.printTreeInPreorder(root);
        System.out.println();

        root = t.buildTreeInLevelOrder(new int[]{3, 4, 5, 1, 3, -1, 1});
        System.out.println("levelOrder");
        t.printTreeInLevelOrder(root);
        System.out.println();
        assertEquals(9, t.rob(root));

    }

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);   // 根节点选或不选的最大值
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int selected = node.val + left[1] + right[1];                                 //selected+左右子节点不选择的最大值
        int notSelected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  //左右子节点可以选也可以不选，取最大值
        return new int[]{selected, notSelected};
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
    }

    // 先序遍历方式生成一颗树
    private TreeNode buildTreeInPreOrder(int[] preOrder, int[] index) {
        if (preOrder == null || index[0] >= preOrder.length || preOrder[index[0]] == -1) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(preOrder[index[0]]);
        index[0]++;  // 使用包装数组来模拟引用传递，避免使用类级别变量
        root.left = buildTreeInPreOrder(preOrder, index);
        root.right = buildTreeInPreOrder(preOrder, index);
        return root;
    }

    private void printTreeInPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTreeInPreorder(root.left);
        printTreeInPreorder(root.right);
    }

    private TreeNode buildTreeInLevelOrder(int[] levelOrder) {
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

    // BFS: queue 利用队列先入先出的特性
    private void printTreeInLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }
}

