import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 509.斐波那契数
 * <a href="https://leetcode.cn/problems/fibonacci-number/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-03.
 */
public class T0509 {
    public static void main(String[] args) {
        T0509 t = new T0509();

        assertEquals(1, t.fib(2));
        assertEquals(2, t.fib(3));
        assertEquals(3, t.fib(4));
    }

//    public int fib(int n) {
//        int maxn = 31;
//        int[] dp = new int[maxn];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 1;
//        for (int i=3; i<=n; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int tmp, a = 0, b = 1;
        for (int i=2; i<=n; i++) {
            tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
}
