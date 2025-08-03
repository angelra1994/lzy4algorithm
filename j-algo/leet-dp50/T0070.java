import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 70.爬楼梯
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-03.
 */
public class T0070 {
    public static void main(String[] args)  {
        T0070 t = new T0070();
        assertEquals(2, t.climbStairs(2));
        assertEquals(3, t.climbStairs(3));
    }

//    public int climbStairs(int n) {
//        // 1 <= n <= 45
//        int maxn = 46;
//        int[] dp = new int[maxn];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;
//
//        // 1 <= n <= 45
//        for (int i=3; i<=n; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }

     public int climbStairs(int n) {
         int tmp=0,p=0,q=1;
         for(int i=1;i<=n;i++) {
             tmp = q;
             q = p + q;
             p = tmp;
         }
         return q;
     }
}
