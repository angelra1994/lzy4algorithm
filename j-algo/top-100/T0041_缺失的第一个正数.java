import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 41. 缺失的第一个正数
 * <a href="https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-23.
 */
public class T0041_缺失的第一个正数 {
    public static void main(String[] args) {
        T0041_缺失的第一个正数 t = new T0041_缺失的第一个正数();
        assertEquals(3, t.firstMissingPositive(new int[]{1, 2, 0}));
        assertEquals(3, t.firstMissingPositive(new int[]{1, 1, 2}));
        assertEquals(4, t.firstMissingPositive(new int[]{3, 2, 1}));
        assertEquals(2, t.firstMissingPositive(new int[]{3, 4, -1, 1}));
        assertEquals(3, t.firstMissingPositive1(new int[]{1, 2, 0}));
    }

    //时间复杂度和空间复杂度都是O(n)
    public int firstMissingPositive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int n = set.size();
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n + 1;
    }


    //nums长度为n，通过交换实现1~n的数字，都按照顺序排放。不在1~n范围的数字，可以先忽略
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int tmp, j = 0;
        for (int i = 0; i < n; i++) {
            // 1 <= nums[i] <= n &&  i = nums[i-1] -> nums[i] = nums[nums[i] -1 ]
            while (nums[i] >= 1 && nums[i] <= n && i + 1 != nums[i] && nums[i] != nums[nums[i] - 1]) {
                j = nums[i] - 1;
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
