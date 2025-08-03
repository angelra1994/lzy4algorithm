import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 1137.第 N 个泰波那契数
 * *<a href="https://leetcode.cn/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-03.
 */
public class T1137 {
    public static void main(String[] args) {
        T1137 t = new T1137();
        assertEquals(0, t.tribonacci(0));
        assertEquals(1, t.tribonacci(1));
        assertEquals(1, t.tribonacci(2));
        assertEquals(4, t.tribonacci(4));
        assertEquals(1389537, t.tribonacci(25));
    }

//    public int tribonacci(int n) {
//        int maxn = 38;
//        int[] dp = new int[maxn];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 1;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
//        }
//        return dp[n];
//    }

    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        int tmp = 0, a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            tmp = c;
            c = a + b + c;
            a = b;
            b = tmp;
        }
        return c;
    }
}
