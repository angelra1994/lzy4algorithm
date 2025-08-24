import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 15. 三数之和
 * <a href="https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-16.
 */
public class T0015_三数之和 {

    public static void main(String[] args) {
        T0015_三数之和 t = new T0015_三数之和();
        assertEquals(2, t.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).size());
        assertEquals(1, t.threeSum(new int[]{-1, -1, 2}).size());

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 先从小到大排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // i-1, i, i+1,
            //  0, [-1],[-1],[3],[-2]  nums[i]=nums[i+1]
            //[-1],[-1],[3],[-2]       避免出现重复的[-1,3,-2]的组合
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 枚举 nums[i]，问题变成 nums[j]+nums[k]=−nums[i]
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                //将三数进行相加
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
