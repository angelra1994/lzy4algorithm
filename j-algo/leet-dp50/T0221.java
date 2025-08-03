import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 221.最大正方形
 * <a href="https://leetcode.cn/problems/maximal-square/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-04.
 */
public class T0221 {
    public static void main(String[] args) {
        T0221 t = new T0221();
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        assertEquals(4, t.maximalSquare(matrix));
        assertEquals(1, t.maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}}));
        assertEquals(0, t.maximalSquare(new char[][]{{'0'}}));
        assertEquals(1, t.maximalSquare(new char[][]{{'0', '1'}}));
    }

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];               // dp[i][j] 表示以 i,j 为右下角的正方形的边长
        int maxLen = 0;                           // 遍历获取到所有边长中的最大值
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxLen = Math.max(maxLen, dp[i][0]);
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j] - '0';
            maxLen = Math.max(maxLen, dp[0][j]);
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
