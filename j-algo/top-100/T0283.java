import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 283.移动零
 * <a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-07.
 */
public class T0283 {
    public static void main(String[] args) {
        T0283 t = new T0283();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        t.moveZeroes(nums);
        assertEquals(12, nums[2]);
        assertEquals(0, nums[3]);
    }

    public void moveZeroes(int[] nums) {
        // 双指针中，使用p1，p2作为追击指针。p1追p2
        int p1 = 0, p2 = 0, tmp = 0;
        while (p2 < nums.length) {
            if (nums[p2] != 0) {
                tmp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = tmp;
                p1++;
            }
            p2++;
        }
    }

}
