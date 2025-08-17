import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 167. 两数之和 II - 输入有序数组
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/">...</a>
 * Created by lzy on 2025-08-16.
 */
public class T0167_两数之和Ⅱ_输入有序数组 {
    public static void main(String[] args) {
        T0167_两数之和Ⅱ_输入有序数组 t = new T0167_两数之和Ⅱ_输入有序数组();
        assertEquals(1, t.twoSum(new int[]{2, 7, 11, 15}, 9)[0]);
        assertEquals(2, t.twoSum(new int[]{2, 7, 11, 15}, 9)[1]);

    }
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}
