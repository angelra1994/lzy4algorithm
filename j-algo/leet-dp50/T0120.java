import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 120.三角形最小路径和
 * <a href="https://leetcode.cn/problems/triangle/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-04.
 */
public class T0120 {
    public static void main(String[] args) {
        T0120 t = new T0120();
        assertEquals(11, t.minimumTotal(List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3))));
        assertEquals(-10, t.minimumTotal(List.of(List.of(-10))));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        // 1 <= triangle.length <= 200
        // triangle[i].length == triangle[i - 1].length + 1

        if (triangle == null || triangle.isEmpty() || triangle.getFirst() == null || triangle.getFirst().isEmpty()) {
            return 0;
        }

//        int maxn = 201;
//        int[][] dp = new int[maxn][maxn];

        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);           // 左边界
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);         // 右边界
        }

        int minTotal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minTotal = Math.min(minTotal, dp[n-1][i]);
        }

        return minTotal;                                               // dp[n−1][0] 到 dp[n−1][n−1] 中的最小值
    }
}
