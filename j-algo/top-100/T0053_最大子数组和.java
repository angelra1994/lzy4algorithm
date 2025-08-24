import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 53. 最大子数组和
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-21.
 */
public class T0053_最大子数组和 {
    public static void main(String[] args) {
        T0053_最大子数组和 t = new T0053_最大子数组和();
        assertEquals(6, t.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(6, t.maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(-1, t.maxSubArray(new int[]{-1}));
        assertEquals(-1, t.maxSubArray1(new int[]{-1}));
    }

    // 子数组和 = 长的前缀和 - 短的前缀和
    public int maxSubArray(int[] nums) {
        // 遍历所有前缀和，并且和当前最小前缀和做差。获取结果中最大值。
        int presum = 0;
        int minpresum = 0;
        int ans = Integer.MIN_VALUE;
        for (int x : nums) {
            presum += x;
            ans = Math.max(ans, presum - minpresum);  // 子数组和 = 长的前缀和 - 短的前缀和（二者长度不能一样）
            minpresum = Math.min(minpresum, presum);
        }
        return ans;
    }

    // dp做法, dp[i] 表示以 nums[i] 结尾的最大子数组和
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            // dp[i] 表示以 nums[i] 结尾的最大子数组和，要么nums[i]和nums[i-1]合并成一个子数组，要么nums[i]单独成子数组
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
