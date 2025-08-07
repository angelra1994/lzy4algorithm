import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 560.和为K的子数组
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-07.
 */
public class T0560 {
    public static void main(String[] args) {
        T0560 t = new T0560();

        assertEquals(2, t.subarraySum(new int[]{1, 1, 1}, 2));
        assertEquals(2, t.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        // 创建一个map，key为前缀和，value为出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return ans;
    }
}
