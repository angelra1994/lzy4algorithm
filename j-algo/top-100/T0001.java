import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 1.两数之和
 * <a href="https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-05.
 */
public class T0001 {
    public static void main(String[] args) {
        T0001 t = new T0001();
        int[] ans = new int[2];
        ans = t.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertEquals(ans[0], 0);
        assertEquals(ans[1], 1);
        ans = t.twoSum(new int[]{3, 3}, 6);
        assertEquals(ans[0], 0);
        assertEquals(ans[1], 1);
    }

    public int[] twoSum(int[] nums, int target) {
        int a,b;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            b = target - a;
            if (map.containsKey(b)) {
                return new int[]{map.get(b), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
