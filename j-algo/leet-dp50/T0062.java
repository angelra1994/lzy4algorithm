import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 62. 不同路径
 * <a href="https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-04.
 */
public class T0062 {
    public static void main(String[] args) {
        T0062 t = new T0062();
        assertEquals(28, t.uniquePaths(3, 7));
        assertEquals(3, t.uniquePaths(3, 2));
        assertEquals(6, t.uniquePaths(3, 3));
        assertEquals(1916797311, t.uniquePaths(51, 9));
        assertEquals(1, t.uniquePaths(1, 100));
    }

//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = 1;
//        }
//        for (int j = 0; j < n; j++) {
//            dp[0][j] = 1;
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//        return dp[m - 1][n - 1];
//    }


    // 总共需要移动 n+m-2次, （m−1 次向下移动，n−1 次向右移动）
    // 从 m+n−2 次移动中选择 m−1 次向下移动的方案数 (m+n−2)!/((m−1)!·(n−1)!) = m·(m+1)···(m+n−2)/(n−1)!
    public int uniquePaths(int m, int n) {
        long res = 1;
        for (int i = 1; i <= n - 1; i++) {
            res = res * (m - 1 + i) / i;
        }
        return (int)res;
    }
}
