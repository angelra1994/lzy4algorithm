import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * brief: 238. 除自身以外数组的乘积
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-23.
 */
public class T0238_除自身以外数组的乘积 {
    public static void main(String[] args) {
        T0238_除自身以外数组的乘积 t = new T0238_除自身以外数组的乘积();
        assertArrayEquals(new int[]{24, 12, 8, 6}, t.productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{24, 12, 8, 6}, t.productExceptSelf1(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, t.productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, t.productExceptSelf1(new int[]{-1, 1, 0, -3, 3}));
    }

    // 不允许使用除法，就是前缀乘积, 后缀乘积
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 定义 pre[i] 表示从 nums[0] 到 nums[i−1] 的乘积, pre[0] = 1
        // 定义 suf[i] 表示从 nums[i+1] 到 nums[n−1] 的乘积, suf[n-1] = 1
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }


        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i] * suf[i];
        }
        return ans;
    }

    // 先计算pre[i], 然后一边计算suf, 一边把suf乘到pre[i]中，最终返回pre[i]
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        // 定义 pre[i] 表示从 nums[0] 到 nums[i−1] 的乘积, pre[0] = 1
        // 定义 suf[i] 表示从 nums[i+1] 到 nums[n−1] 的乘积, suf[n-1] = 1
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int suf = 1;
        for (int i = n - 1; i >= 0; i--) {
            pre[i] *= suf;
            suf *= nums[i];
        }

        return pre;
    }
}
