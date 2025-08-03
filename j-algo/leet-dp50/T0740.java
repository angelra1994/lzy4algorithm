import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 740.删除并获得点数
 * <a href="https://leetcode.cn/problems/delete-and-earn/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-03.
 */
public class T0740 {
    public static void main(String[] args) {
        T0740 t = new T0740();
        assertEquals(6, t.deleteAndEarn(new int[]{3, 4, 2}));
        assertEquals(9, t.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));

    }

    public int deleteAndEarn(int[] nums) {
        // [2, 2, 3, 3, 3, 4] -> [0, 0, 4, 9, 4]
        // [2, 2, 3, 3, 3, 4, 4] -> [0, 0, 4, 9, 8]. nums中的最大值是4, 转换成 int[4+1] 的数组
        int max = 0;
        for (int num: nums) {
            max = Math.max(max, num);
        }
        int[] sums = new int[max+1];
        for (int num: nums) {
            sums[num] += num;
        }

        return rob(sums);
    }

//    private int rob(int[] nums) {
//        if (1 == nums.length) {
//            return nums[0];
//        }
//
//        int tmp, a = nums[0], b = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            tmp = b;                         // 之前的i-1,暂存tmp
//            b = Math.max(a + nums[i], b);    // 状态转移：当前最大收益=max(偷当前房子, 不偷当前房子)
//            a = tmp;                         // 更新i-2为之前的i-1
//        }
//        return b;
//    }

    private int rob(int[] nums) {
        // 1 <= nums.length <= 10^4
        int maxn = 10001;
        int[] dp = new int[maxn];
        for (int i = 1; i < nums.length; i++) {
            if (1 == i) {
                dp[i] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
        }
        return dp[nums.length - 1];

    }
}
