import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 64.最小路径和
 * <a href="https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-04.
 */
public class T0064_最小路径和 {
    public static void main(String[] args) {
        T0064_最小路径和 t = new T0064_最小路径和();
        assertEquals(7, t.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        assertEquals(12, t.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];

    }
}
