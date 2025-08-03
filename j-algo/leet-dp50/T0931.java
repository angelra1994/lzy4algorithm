import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 931.下降路径最小和
 * <a href="https://leetcode.cn/problems/minimum-falling-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-04.
 */
public class T0931 {
    public static void main(String[] args) {
        T0931 t = new T0931();
        assertEquals(13, t.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        assertEquals(-59, t.minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));
    }

    public int minFallingPathSum(int[][] matrix) {
        //1 <= n <= 100
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {                                                        // 第一行处理
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = matrix[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);                    // i行0列
            for (int j = 1; j < n - 1; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
            }
            dp[i][n - 1] = matrix[i][n - 1] + Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]);    // i行n-1列
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[n - 1][i]);
        }
        return minSum;
    }
}
