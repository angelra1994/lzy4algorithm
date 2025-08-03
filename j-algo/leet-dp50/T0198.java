import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 198.打家劫舍
 * <a href="https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-03.
 */
public class T0198 {
    public static void main(String[] args) {
        T0198 t = new T0198();

        assertEquals(4, t.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, t.rob(new int[]{2, 7, 9, 3, 1}));
    }

//    public int rob(int[] nums) {
//        // 1 <= nums.length <= 100
//        int maxn = 101;
//        int[] dp = new int[maxn];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (i == 1) {
//                dp[i] = Math.max(nums[0], nums[1]);
//            } else {
//                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//            }
//        }
//        return dp[nums.length - 1];
//    }

//    public int rob(int[] nums) {
//        if (1 == nums.length) {
//            return nums[0];
//        }
//
//        int a=0;
//        int b=nums[0];
//        int r = 0;
//        // 1 <= nums.length <= 100
//        for(int i=1;i<nums.length;i++) {
//            if (1 == i) {
//                r = Math.max(nums[0], nums[1]);
//            } else {
//                a = b;          // 更新i-2为之前的i-1
//                b = r;          // 更新i-1为之前的当前值
//                r = Math.max(a + nums[i], b);  // 状态转移：当前最大收益=max(偷当前房子, 不偷当前房子)
//            }
//        }
//        return r;
//    }

    public int rob(int[] nums) {
        if (1 == nums.length) {
            return nums[0];
        }

        int tmp, a = nums[0], b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            tmp = b;
            b = Math.max(a + nums[i], b);
            a = tmp;
        }
        return b;
    }
}
