import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 283.移动零
 * <a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-07.
 */
public class T0283_移动零 {
    public static void main(String[] args) {
        T0283_移动零 t = new T0283_移动零();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        t.moveZeroes(nums);
        assertEquals(12, nums[2]);
        assertEquals(0, nums[3]);
    }

    public void moveZeroes(int[] nums) {
        // 双指针中，如果快的遇到不是0的数字，就和慢指针交换位置。交换完毕后。slow移动一位
        int slow = 0, fast = 0, tmp = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
            fast++;
        }
    }

}
