import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 189.轮转数组
 * <a href="https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-08.
 */
public class T0189 {

    public static void main(String[] args) {
        T0189 t = new T0189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        t.rotate(nums, 3);
        assertEquals(5, nums[0]);

    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // 12345 -> [54][321] -> [45][123] -> 45123
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        int tmp = 0;
        while (l < r) {
            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;

        // 12345
        // 45123
        int[] temp = new int[nums.length];
        // for (int i = 0; i < nums.length-k; i++) {
        //     temp[k+i] = nums[i];
        // }
        // for (int i = nums.length-k; i < nums.length; i++) {
        //     temp[(k+i)%nums.length] = nums[i];
        // }
        for (int i = 0; i < nums.length; i++) {
            temp[(k + i) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
