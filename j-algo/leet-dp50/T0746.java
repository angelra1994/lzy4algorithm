import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 746.使用最小花费爬楼梯
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-03.
 */
public class T0746 {
    public static void main(String[] args) {
        T0746 t = new T0746();

        assertEquals(15, t.minCostClimbingStairs(new int[]{10, 15, 20}));
        assertEquals(6, t.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

//    public int minCostClimbingStairs(int[] cost) {
//        int maxn = 1001;
//        int n = cost.length;
//        int[] dp = new int[maxn];
//        dp[0] = 0;
//        dp[1] = 0;
//        for (int i = 2; i <= n ; i++) {
//            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
//        }
//        return dp[n];
//    }

//    public int minCostClimbingStairs(int[] cost) {
//        int a=0,b=0,r=0;
//        // 2 <= cost.length <= 1000
//        for(int i=2;i<=cost.length;i++) {
//            a = b;
//            b = r;
//            r = Math.min(a + cost[i-2], b + cost[i-1]);
//        }
//        return r;
//    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int tmp, a = 0, b = 0;
        // 2 <= cost.length <= 1000
        for (int i = 2; i <= n; i++) {
            tmp = b;
            b = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = tmp;
        }
        return b;
    }
}
